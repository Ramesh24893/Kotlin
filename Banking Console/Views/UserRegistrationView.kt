package Views

import Model.User
import java.util.*

class UserRegistrationView : UserRegistrationUI {
    var scannerObject = Scanner(System.`in`)
    var validObj = Validation()

    override val newUserName: String
        get() {
            println("Enter the new username")
            var name: String
            var count = 1
            do {
                if (count > 1) {
                    println("Enter the valid user name")
                    println("1. User name can be alphanumeric\n2. start with alphabet and range of letters 8 to 30 \n3.Allowed special characters @,_ ")
                }
                name = scannerObject.nextLine()
                count++
            } while (!validObj.validateUserName(name))
            return name
        }

    override val newPassword: String
        get() {
            println("Enter the new password")
            var name: String
            var count = 1
            do {
                if (count > 1) {
                    println("Enter the valid password")
                    println("a digit must occur at least once\n" +
                            "a lower case letter must occur at least once\n" +
                            "an upper case letter must occur at least once\n" +
                            "a special character must occur at least once\n" +
                            "no whitespace allowed in the entire string\n" +
                            "at least 8 characters")
                }
                name = scannerObject.nextLine()
                count++
            } while (!validObj.validatePassword(name))
            return name
        }

    override fun userRegisteredNotification(user: User) {
        println("\nYour account is created\nACCOUNT DETAILS")
        println(user)
    }

    override fun userIdExistNotification() {
        println("\nUser Id already exists")
    }
}