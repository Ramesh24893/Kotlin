package Views

interface UserRequestUI {

    fun requestSubmissionNotification(form: String)

    val loanAmount: Long

    fun invalidRequestNotification(cardType: String)

    fun getNewBranchCode(branches: Set<String>): String

    fun displayBranches(branchesList: Set<String>)

    fun reqAlreadySubmitted()

    fun previousBranchGivenNoti()
}