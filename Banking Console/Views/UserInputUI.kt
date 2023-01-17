package Views

interface UserInputUI {

    fun displayAccountStatus(account: String)

    fun displayMessages(messages: List<String>)

    fun displayAvailableBalance(balance: Long)
}