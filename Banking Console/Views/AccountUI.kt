package Views

import kotlinx.coroutines.flow.Flow

interface AccountUI {

    fun getBranchCode(branches: Set<String>): String

    val name: String

    val mobileNum: Long

    val existingAccountNumber: Long

    fun existingAccountLinkingFailed()

    fun existingAccountLinkingSuccessful()

    fun accCreationSuccessfulNotification()

    val fathersName: String

    val aadhaarNumber: Long

    val panNumber: String

    val cityName: String

    val age: Int

    val gender: String

    fun displayBranches(branches: Flow<String>)

    fun accDeletionMessage()
}