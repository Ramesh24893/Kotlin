package Views

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.runBlocking
import java.util.Scanner

class TransactionView : TransactionUI {
    var scannerObj = Scanner(System.`in`)
    var validation = Validation()

    override val amountForTransaction: Int
        get() {
            var amount: Int
            var count = 1
            do {
                if (count > 1) {
                    println("\nEnter the valid amount")
                }
                println("\nEnter the amount")
                while (!scannerObj.hasNextInt()) {
                    println("Enter the valid amount")
                    scannerObj.next()
                }
                amount = scannerObj.nextInt()
                count++
            } while (amount <= 0)
            return amount
        }

    override fun displayReceipt(receipt: String) {
        println(receipt)
    }

    override val receiverAccountNumber: Long
        get() {
            println("\nEnter receiver account number")
        while (!scannerObj.hasNextLong()) {
            println("\nEnter the data in number")
            println("Enter receiver account number")
            scannerObj.next()
        }
        return scannerObj.nextLong()
    }

    override fun  displayAllTransactions(transactions: Flow<String>): Unit = runBlocking{
//        if (transactions.isEmpty()) {
//            println("\nNo Transaction  made\n")
//            return
//        }
//        for (transaction in transactions) {
//            println("===========================================")
//            println(transaction)
//            println("===========================================")
//        }


        transactions.collect{transaction->
            println("===========================================")
            println(transaction)
            println("===========================================")
        }
    }




    override fun transactionSuccessMessage() {
        println("\n\n  Transaction successful  ")
    }

    override fun transactionFailedMessage() {
        println("****************************************")
        println("|     Transaction Failed               |")
        println("|       Balance is low                 |")
        println("|     Deposit some amount              |")
        println("****************************************")
    }

    override fun depositLimitedReachedNotification(limit: Long) {
        println("Transaction failed")
        println("Deposit Limit  is $limit")
    }

    override fun withdrawLimitReachedNotification(limit: Long) {
        println("Transaction failed")
        println("Withdraw Limit is $limit")
    }

    override fun transferLimitReachedNotification(limit: Long) {
        println("Transaction failed")
        println("Transfer limit is $limit")
    }

    override fun branchLimitReached(branchResAmt: Long) {
        println("Transaction Failed")
        println("Now Bank can provide you less than Rs $branchResAmt")
    }

    override fun noSuchAccountExist() {
        println("No such account number exist")
    }
}