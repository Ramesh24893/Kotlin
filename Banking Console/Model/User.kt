package Model



data class User(
    val userId: String,
    val password: String,
    val messages: ArrayList<String> = ArrayList<String>(),
    var account: Account? = null,
){
    override fun toString(): String {

       return  """
     UserName: $userId
     Password: $password
     Linked Bank Account :${ account?.accountNumber ?:"No account Linked"}
     """.trimIndent()
    }
}