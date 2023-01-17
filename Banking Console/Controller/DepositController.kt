package Controller

import Data.BankDataBase
import Model.Account
import Model.Branch
import Views.TransactionUI

class DepositController(

    private val taxDebitControllerObj: TransactionTaxDebiter,
    private val transactionViewObj: TransactionUI,
    private val receiptGeneratorObj: TransactionDataGenerator,

) {
    fun initiateDeposit(account: Account) {

        val depositAmount = transactionViewObj.amountForTransaction

        if (depositAmount > account.depositLimit) {
            transactionViewObj.depositLimitedReachedNotification(account.depositLimit.toLong())
        }
        else {

            val branch = BankDataBase.branches[account.branchCode]
            deposit(account, depositAmount, branch)
            val taxAmount = taxDebitControllerObj.debitDepositTax(depositAmount, account)
            branch!!.reserveAmount = branch.reserveAmount + taxAmount
            val data = receiptGeneratorObj.generateDepositTransactionData(
                depositAmount.toLong(),
                account.balance,
                taxAmount.toLong()
            )

            account.transactions.add(data)
            transactionViewObj.transactionSuccessMessage()
            transactionViewObj.displayReceipt(data)
        }
    }

    private fun deposit(account: Account, amount: Int, branch: Branch?) {
        val debtAmount = account.debtAmt

        if (debtAmount > 0) {
            if (amount > debtAmount) {
                account.balance = (amount - debtAmount).toLong()
                account.overDraftLimit = account.overDraftLimit + debtAmount
                account.debtAmt = 0
            } else {
                account.debtAmt = debtAmount - amount
                account.overDraftLimit = account.overDraftLimit + amount
            }
        } else {
            val updatedBalance = account.balance + amount
            account.balance = updatedBalance
        }
        branch!!.reserveAmount = branch.reserveAmount + amount
    }
}