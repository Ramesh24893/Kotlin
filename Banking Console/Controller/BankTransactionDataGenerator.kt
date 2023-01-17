package Controller

interface BankTransactionDataGenerator {

    fun generateWithDrawTransactionData(amount: Long, accountBalance: Long, taxAmount: Long): String

    fun generateDepositTransactionData(amount: Long, accountBalance: Long, taxAmount: Long): String

    fun generateSenderTransactionData(amount: Long, receiverAccountNum: Long, accountBalance: Long, taxAmount: Long): String

    fun generateReceiverTransactionData(amount: Long, senderAccountNum: Long, accountBalance: Long): String
}