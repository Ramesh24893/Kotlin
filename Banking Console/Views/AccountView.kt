package Views

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.runBlocking
import java.util.*

class AccountView : AccountUI {
    var scannerObj = Scanner(System.`in`)
    var validObj = Validation()

    override fun getBranchCode(branches: Set<String>): String {
        println("Enter the branch code")
        var branch: String
        var count = 1
        do {
            if (count > 1) {
                println("Enter valid branch code")
            }
            branch = scannerObj.nextLine()
            count++
        } while (!branches.contains(branch))
        return branch
    }

    override val name: String
        get() {
            println("Enter the Account Holder name")
            var name: String
            var count = 1
            do {
                if (count > 1) {
                    println("Enter the valid name")
                }
                name = scannerObj.nextLine()
                count++
            } while (!validObj.validateName(name))
            return name
        }

    override val mobileNum: Long
        get() {
            val scannerObj = Scanner(System.`in`)
            var num: Long
            var count = 1
            do {
                if (count > 1) {
                    println("Mobile number consists of 10 digits")
                }
                println("Enter the mobile number")
                while (!scannerObj.hasNextLong()) {
                    println("Enter the data in number")
                    println("Enter the Mobile Number")
                    scannerObj.next()
                }
                num = scannerObj.nextLong()
                count++
            } while (!validObj.validateMobileNum(num.toString()))
            return num
        }

    override val existingAccountNumber: Long
        get() {
            var num: Long
            var count = 1
            do {
                if (count > 1) {
                    println("Account number consists of 14 digits")
                }
                println("Enter the existing account Number")
                while (!scannerObj.hasNextLong()) {
                    println("Enter the data in number")
                    println("Enter the existing account Number")
                    scannerObj.next()
                }
                num = scannerObj.nextLong()
                count++
            } while (!validObj.validateAccNumber(num.toString()))
            return num
        }

    override val fathersName: String
        get() {
            println("Enter your fathers name")
            var fatherName: String
            var count = 1
            do {
                if (count > 1) {
                    println("Enter the valid name")
                }
                fatherName = scannerObj.nextLine()
                count++
            } while (!validObj.validateName(fatherName))
            return fatherName
        }

    override val aadhaarNumber: Long
        get() {
            println("Enter Aadhaar Number")
            var num: Long
            var count = 1
            do {
                if (count > 1) {
                    println("Aadhaar number consists of 12 digits")
                    println("Enter valid Aadhaar Number")
                }
                while (!scannerObj.hasNextLong()) {
                    println("Enter the data in number")
                    println("Enter Aadhaar Number")
                    scannerObj.next()
                }
                num = scannerObj.nextLong()
                count++
            } while (!validObj.validateAadhaar(num.toString()))
            return num
        }

    override val panNumber: String
        get() {
            scannerObj.nextLine()
            println("Enter the pan number")
            var panNum: String
            var count = 1
            do {
                if (count > 1) {
                    println("Enter the valid pan number")
                    println("First 5 letter A-Z\nNext 4 letter0-9\nlast Letter A-Z")
                }
                panNum = scannerObj.nextLine()
                count++
            } while (!validObj.validatePan(panNum))
            return panNum
        }

    override val cityName: String
        get() {
            println("Enter the city name")
            var city: String
            var count = 1
            do {
                if (count > 1) {
                    println("Enter the valid city name")
                }
                city = scannerObj.nextLine()
                count++
            } while (!validObj.validateName(city))
            return city
        }

    override val age: Int
        get() {
            println("Enter age in number")
            var age = 0
            var count = 1
            do {
                if (count > 1) {
                    scannerObj.next()
                    println("Enter the valid age")
                }
                count++
            } while (!scannerObj.hasNextInt())
            age = scannerObj.nextInt()
            return age
        }

    override val gender: String
        get() {
            scannerObj.nextLine()
            println("Enter gender\n\nM for Male\nF for Female\nO for Others")
            var gender: String
            var count = 1
            do {
                if (count > 1) {
                    println("Enter M or F or O")
                }
                gender = scannerObj.nextLine()
                count++
            } while (!validObj.validateGender(gender))
            return gender
        }

    override fun accDeletionMessage() {
        println("\n Your account is deleted")
    }

    override fun existingAccountLinkingFailed() {
        println("Linking with existing account is failed")
    }

    override fun existingAccountLinkingSuccessful() {
        println("Linking with existing account is successful")
    }

    override fun accCreationSuccessfulNotification() {
        println("account created successfully")
    }

    override fun displayBranches(branches: Flow<String>) = runBlocking{
        println("------------------ALL BRANCHES------------------\n")
        branches.collect {branch->
            println("Branch Code :$branch")
            println("----------------------------------------------------\n")
        }
    }
}