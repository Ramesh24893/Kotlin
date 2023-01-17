package Controller

import Data.BankDataBase
import Model.User
import Views.LoginUserUI

class LoginUserController( private val logUserUI: LoginUserUI, ) : Login {

    override fun login(): User? {

        val userName = logUserUI.userNameForValidation

        if (!checkValidUserId(userName)) {
            return null
        }
        val userPassword = logUserUI.userPasswordForValidation
        if (!verify(userName, userPassword)) {
            logUserUI.inValidUserNotification()
            return null
        }
        return BankDataBase.users[userName]
    }

    private fun checkValidUserId(userId: String): Boolean {

        if (!BankDataBase.users.containsKey(userId)) {
            logUserUI.noSuchUserNotification()
            return false
        }
        return true
    }

    override fun verify(userName: String, password: String): Boolean {

        val user: User? = BankDataBase.users[userName]
        return user!!.userId == userName && user.password == password
    }
}