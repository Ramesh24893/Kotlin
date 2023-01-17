package Controller

import Data.BankDataBase
import Model.User
import Views.UserRegistrationUI

class UserRegistrationController(private val userRegUI: UserRegistrationUI,  ) : Registration
{
    override fun register(): User {
        var newUserName: String
        var count = 1
        do {
            if (count > 1) {
                userRegUI.userIdExistNotification()
            }
            newUserName = userRegUI.newUserName
            count++
        } while (isUserIdExists(newUserName))
        val password = userRegUI.newPassword
        return createUserAcc(newUserName, password)
    }

    override fun isUserIdExists(newUserName: String): Boolean {
        return BankDataBase.users.containsKey(newUserName)
    }

    override fun createUserAcc(newUserName: String, password: String): User {
        val userObj = User(newUserName, password)
        BankDataBase.users[newUserName] = userObj
        userRegUI.userRegisteredNotification(userObj)
        return userObj
    }
}