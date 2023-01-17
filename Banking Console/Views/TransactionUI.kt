package Views

import kotlinx.coroutines.flow.Flow




interface TransactionUI {

    val amountForTransaction: Int

    fun displayReceipt(receipt: String)

    val receiverAccountNumber: Long

     fun displayAllTransactions(transactions: Flow<String>)

    fun transactionSuccessMessage()

    fun transactionFailedMessage()

    fun depositLimitedReachedNotification(limit: Long)

    fun withdrawLimitReachedNotification(limit: Long)

    fun transferLimitReachedNotification(limit: Long)

    fun branchLimitReached(branchResAmt: Long)

    fun noSuchAccountExist()
}