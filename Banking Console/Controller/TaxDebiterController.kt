package Controller

import Data.BankDataBase
import Model.Account

class TaxDebiterController( private val rateCalc: TransactionTaxCalculator) :
    TransactionTaxDebiter {
//    override fun debitWithdrawTax(amount: Int, account: Account): Int {
//
//    }
//
//    override fun debitAccountToAccountTransferTax(amount: Int, account: Account): Int {
//        val taxAmt = rateCalc.calcAccountToAccountTransferTax(amount)
//        updateAccAndBranch(account, taxAmt)
//        return taxAmt
//    }

//    override fun debitDepositTax(amount: Int, account: Account): Int {
//        val taxAmt = rateCalc.calcDepositTax(amount)
//        updateAccAndBranch(account, taxAmt)
//        return taxAmt
//    }

    fun updateAccAndBranch(account: Account, taxAmt: Int) {
        val accBalance = account.balance.toInt()
        if (taxAmt > accBalance) {
            val amount = taxAmt - accBalance
            account.debtAmt = account.debtAmt + amount
            account.overDraftLimit = account.overDraftLimit - amount
            account.balance = 0
        } else {
            account.balance = account.balance - taxAmt
        }
        val branchCode = account.branchCode
        val branch = BankDataBase.branches[branchCode]
        account.totalChargesPaid = account.totalChargesPaid + taxAmt
        val amt = branch!!.branchProfit + taxAmt
        branch.branchProfit = amt
    }

    override fun debitWithdrawTax(amount: Int, account: Account?): Int {
        val taxAmt = rateCalc.calcWithDrawTax(amount)
        updateAccAndBranch(account!!, taxAmt)
        return taxAmt
    }

    override fun debitAccountToAccountTransferTax(amount: Int, account: Account?): Int {
        val taxAmt = rateCalc.calcAccountToAccountTransferTax(amount)
        updateAccAndBranch(account!!, taxAmt)
        return taxAmt
    }

    override fun debitDepositTax(amount: Int, account: Account?): Int {
        val taxAmt = rateCalc.calcDepositTax(amount)
        updateAccAndBranch(account!!, taxAmt)
        return taxAmt
    }
}