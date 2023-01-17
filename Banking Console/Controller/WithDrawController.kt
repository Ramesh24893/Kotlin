package Controller

import Data.BankDataBase
import Model.Account
import Model.Branch
import Views.TransactionUI

class WithDrawController(
    private val taxDebitControllerObj: TransactionTaxDebiter,
    private val transactionViewObj: TransactionUI,
    private val receiptGeneratorObj: TransactionDataGenerator,
    private val rateCalc: TransactionTaxCalculator
) {
    fun initiateWithdraw(account: Account) {
        val amount = transactionViewObj.amountForTransaction
        val taxAmt = rateCalc.calcWithDrawTax(amount)

        if (amount > account.withdrawLimit)
            transactionViewObj.withdrawLimitReachedNotification(account.withdrawLimit.toLong())

        else if (!bankLimit(account, amount))
            return

        else if (amount + taxAmt >= account.balance + account.overDraftLimit)
            transactionViewObj.transactionFailedMessage()

        else {
            val branch = BankDataBase.branches[account.branchCode]
            withdraw(account, amount, branch)
            val taxAmount = taxDebitControllerObj.debitWithdrawTax(amount, account)
            branch!!.reserveAmount = branch.reserveAmount + taxAmount
            val data = receiptGeneratorObj.generateWithDrawTransactionData(
                amount.toLong(),
                account.balance,
                taxAmount.toLong()
            )
            transactionViewObj.transactionSuccessMessage()
            transactionViewObj.displayReceipt(data)
            account.transactions.add(data)
        }
    }

    private fun withdraw(account: Account, amount: Int, branch: Branch?) {
        val balance = account.balance.toInt()
        if (amount > balance) {
            account.debtAmt = account.debtAmt + (amount - balance)
            account.overDraftLimit = account.overDraftLimit - (amount - balance)
            account.balance = 0
        } else {
            val updatedBalance = account.balance.toInt() - amount
            account.balance = updatedBalance.toLong()
        }
        branch!!.reserveAmount = branch.reserveAmount - amount
    }

    private fun bankLimit(account: Account, amount: Int): Boolean {
        val branchOfAcc = BankDataBase.branches[account.branchCode]
        val branchResAmt = branchOfAcc!!.reserveAmount
        if (amount > branchResAmt) {
            transactionViewObj.branchLimitReached(branchResAmt)
            return false
        }
        return true
    }
}


//private void  withdraw(Account account, int amount,Branch branch){
//
//    int balance=(int)account.getBalance();
//
//    if(amount>balance){
//        account.setDebtAmt(account.getDebtAmt()+(amount-balance));//amount-balance;
//        account.setOverDraftLimit(account.getOverDraftLimit()-(amount-balance));
//        account.setBalance(0);
//
//    }
//    else {
//        int updatedBalance = (int) account.getBalance() - amount;
//        account.setBalance(updatedBalance);
//    }
//
//    branch.setReserveAmount(branch.getReserveAmount()-amount);
//
//}
//private fun withdraw1(account:Account,amount:Int,branch:Branch) {
//    val balance= account.balance
//    if(amount>balance){
//        account.debtAmt=
//    }
//}