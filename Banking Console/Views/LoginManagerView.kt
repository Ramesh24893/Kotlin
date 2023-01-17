package Views

import java.util.*

class LoginManagerView() : LoginManagerUI {
    var scannerObject = Scanner(System.`in`)

    override val managerUserNameForValidation: String
        get() {
            println("Enter the Manager username")
            return scannerObject.nextLine()
        }

    override val managerPasswordForValidation: String
        get() {
            println("Enter the Manager password")
            return scannerObject.nextLine()
        }

    override fun invalidManagerLoginNotification() {
        println("Invalid manager login data")
    }

    override fun invalidDataNotification() {
        println("Enter valid data")
    }
}