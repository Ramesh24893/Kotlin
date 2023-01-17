package Controller

interface TransactionTaxCalculator {

    fun calcWithDrawTax(amount: Int): Int

    fun calcDepositTax(amount: Int): Int

    fun calcAccountToAccountTransferTax(amount: Int): Int
}