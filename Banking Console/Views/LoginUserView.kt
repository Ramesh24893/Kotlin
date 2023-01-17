package Views

import java.util.*

class LoginUserView : LoginUserUI {

    var scannerObject = Scanner(System.`in`)

    override val userNameForValidation: String
        get()  {
            println("\nEnter the user name")
            return scannerObject.nextLine()
        }

    override val userPasswordForValidation: String
        get() {
            println("\nEnter the user password")
            return scannerObject.nextLine()
        }

    override fun inValidUserNotification() {
        println("\nEnter the valid username and password")
    }

    override fun noSuchUserNotification() {
        println("\nNo such userId exists")
    }
}