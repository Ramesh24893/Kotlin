package Controller

import Data.BankDataBase
import Views.LoginManagerUI

class LoginManagerController(private val managerUI: LoginManagerUI,) : Login {

    override fun login(): Boolean {

        if (!verify(managerUI.managerUserNameForValidation, managerUI.managerPasswordForValidation)) {
            managerUI.invalidManagerLoginNotification()
            return true
        }
        return false
    }

    override fun verify(userName: String, password: String): Boolean {

        val (managerUserName, managerPassword) = BankDataBase.manager
        print(managerUserName)
        print(managerPassword)
        return managerUserName == userName && managerPassword == password
    }
}