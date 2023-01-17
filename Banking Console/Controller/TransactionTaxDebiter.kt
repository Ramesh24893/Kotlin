package Controller

import Model.Account

interface TransactionTaxDebiter {

    fun debitWithdrawTax(amount: Int, account: Account?): Int

    fun debitAccountToAccountTransferTax(amount: Int, account: Account?): Int

    fun debitDepositTax(amount: Int, account: Account?): Int
}