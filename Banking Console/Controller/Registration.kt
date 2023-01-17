package Controller

import Model.User

interface Registration {
    fun register(): User

    fun createUserAcc(newUserName: String, password: String): Any

    fun isUserIdExists(newUserName: String): Boolean
}