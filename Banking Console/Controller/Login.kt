package Controller

interface Login {

    fun login(): Any?

    fun verify(userName: String, password: String): Boolean
}