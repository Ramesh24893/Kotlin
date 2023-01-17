package Controller

import java.time.LocalDate
import java.time.LocalTime

class TransactionDataGenerator : BankTransactionDataGenerator {
    override fun generateWithDrawTransactionData(amount: Long, accountBalance: Long, taxAmount: Long): String {
        return """
            Transaction Type : Withdraw
            Amount           : $amount
            Date             : ${LocalDate.now()}
            Time             : ${LocalTime.now().hour}:${LocalTime.now().minute}
            Tax Charged      : $taxAmount
            Balance          : $accountBalance
            """.trimIndent()
    }

    override fun generateDepositTransactionData(amount: Long, accountBalance: Long, taxAmount: Long): String {
        return """
            Transaction Type : Deposit
            Amount           : $amount
            Date             : ${LocalDate.now()}
            Time             : ${LocalTime.now().hour}:${LocalTime.now().minute}
            Tax Charged      : $taxAmount
            Balance          : $accountBalance
            """.trimIndent()
    }

    override fun generateSenderTransactionData(
        amount: Long,
        receiverAccountNum: Long,
        accountBalance: Long,
        taxAmount: Long
    ): String {
        return """
            Transaction Type : Account to Account
            DebitAmount      : $amount
            Date             : ${LocalDate.now()}
            Time             : ${LocalTime.now().hour}:${LocalTime.now().minute}
            Receiver Acc     : $receiverAccountNum
            Tax Charged      : $taxAmount
            Balance          : $accountBalance
            """.trimIndent()
    }

    override fun generateReceiverTransactionData(amount: Long, senderAccountNum: Long, accountBalance: Long): String {
        return """
            Transaction Type : Account to Account
            CreditAmount     : $amount
            Date             : ${LocalDate.now()}
            Time             : ${LocalTime.now().hour}:${LocalTime.now().minute}
            Sender Acc       : $senderAccountNum
            Balance          : $accountBalance
            """.trimIndent()
    }
}