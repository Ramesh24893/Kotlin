package Controller

import Data.BankDataBase
import Model.Account
import Model.Branch
import Views.TransactionUI

class OnlineTransferController(
    private val taxDebitControllerObj: TransactionTaxDebiter,
    private val transactionViewObj: TransactionUI,
    private val receiptGeneratorObj: TransactionDataGenerator,
    private val rateCalc: TransactionTaxCalculator
) {
    fun initiateOnlineTransfer(senderAccount: Account) {
        val amount = transactionViewObj.amountForTransaction
        val taxAmt = rateCalc.calcWithDrawTax(amount)
        if (amount > senderAccount.transferLimit) {
            transactionViewObj.transferLimitReachedNotification(senderAccount.transferLimit.toLong())
        }
        else if (!bankAccess(senderAccount, amount)) {
            return
        }
        else if (amount + taxAmt >= senderAccount.balance + senderAccount.overDraftLimit) transactionViewObj.transactionFailedMessage() else {
            val receiverAccNumber = transactionViewObj.receiverAccountNumber
            val receiverAcc = BankDataBase.accounts[receiverAccNumber]
            if (receiverAcc == null) {
                transactionViewObj.noSuchAccountExist()
                return
            }
            val senderBranch = BankDataBase.branches[senderAccount.branchCode]
            transferToAccount(senderAccount, receiverAcc, amount, senderBranch)
            val taxAmount = taxDebitControllerObj.debitAccountToAccountTransferTax(amount, senderAccount)
            senderBranch!!.reserveAmount = senderBranch.reserveAmount + taxAmount
            val senderReceipt = receiptGeneratorObj.generateSenderTransactionData(
                amount.toLong(),
                receiverAccNumber,
                senderAccount.balance,
                taxAmount.toLong()
            )
            senderAccount.transactions.add(senderReceipt)
            val receiverReceipt = receiptGeneratorObj.generateReceiverTransactionData(
                amount.toLong(),
                senderAccount.accountNumber,
                receiverAcc.balance
            )
            receiverAcc.transactions.add(receiverReceipt)
            transactionViewObj.transactionSuccessMessage()
            transactionViewObj.displayReceipt(senderReceipt)
        }
    }

    fun transferToAccount(senderAccount: Account, receiverAccount: Account, amount: Int, senderBranch: Branch?) {
        updateReceiverAccount(receiverAccount, amount)
        updateSenderAccount(senderAccount, amount)
        senderBranch!!.reserveAmount = senderBranch.reserveAmount - amount
        val receiverBranch = BankDataBase.branches[senderAccount.branchCode]
        receiverBranch!!.reserveAmount = receiverBranch.reserveAmount + amount
    }

    fun updateReceiverAccount(receiverAcc: Account, amount: Int) {
        val debtAmount = receiverAcc.debtAmt
        if (debtAmount > 0) {
            if (amount > debtAmount) {
                receiverAcc.balance = (amount - debtAmount).toLong()
                receiverAcc.overDraftLimit = receiverAcc.overDraftLimit + debtAmount
                receiverAcc.debtAmt = 0
            } else {
                receiverAcc.debtAmt = debtAmount - amount
                receiverAcc.overDraftLimit = receiverAcc.overDraftLimit + amount
            }
        } else {
            val updatedBalance = receiverAcc.balance.toInt() + amount
            receiverAcc.balance = updatedBalance.toLong()
        }
    }

    fun updateSenderAccount(account: Account, amount: Int) {
        val balance = account.balance.toInt()
        if (amount > balance) {
            account.debtAmt = account.debtAmt + (amount - balance)
            account.overDraftLimit = account.overDraftLimit - (amount - balance)
            account.balance = 0
        } else {
            val updatedBalance = account.balance.toInt() - amount
            account.balance = updatedBalance.toLong()
        }
    }

    fun bankAccess(account: Account, amount: Int): Boolean {
        val branchOfAcc = BankDataBase.branches[account.branchCode]
        val branchResAmt = branchOfAcc!!.reserveAmount
        if (amount > branchResAmt) {
            transactionViewObj.branchLimitReached(branchResAmt)
            return false
        }
        return true
    }
}