package Controller

class TaxCalcController : TransactionTaxCalculator {
    private val accountToAccountTaxRate = 0.003f
    private val depositTaxRate = 0.002f
    private val withdrawTaxRate = 0.005f

    override fun calcWithDrawTax(amount: Int): Int {
        return (amount * withdrawTaxRate).toInt()
    }

    override fun calcDepositTax(amount: Int): Int {
        return (amount * depositTaxRate).toInt()
    }

    override fun calcAccountToAccountTransferTax(amount: Int): Int {
        return (amount * accountToAccountTaxRate).toInt()
    }
}