package Views

class UserInputView : UserInputUI {
    override fun displayAccountStatus(account: String) {
        println(account)
    }

    override fun displayMessages(messages: List<String>) {
        println(
            """
    -------------------------------------------------
    -----------------------MESSAGES------------------
    -------------------------------------------------
    """.trimIndent()
        )
        if (messages.isEmpty()) println("No message received")
        for (message in messages) {
            println(message)
            println("\n--------------------------------")
        }
    }

    override fun displayAvailableBalance(balance: Long) {
        println(
            """---------------------------------------
         Available Balance   : Rs $balance
---------------------------------------"""
        )
    }
}