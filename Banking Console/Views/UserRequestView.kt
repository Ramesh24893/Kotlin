package Views

import java.util.Scanner

class UserRequestView : UserRequestUI {
    var scannerObj = Scanner(System.`in`)
    override fun requestSubmissionNotification(form: String) {
        when (form) {
            "credit" -> println("\nApplication for credit card submitted to Manager")
            "debit" -> println("\nApplication for debit card submitted to Manager")
            "loan" -> println("\nApplication for loan submitted to Manager")
            "branchChange" -> println("\nApplication for branch Change submitted to Manager")
        }
    }

    override val loanAmount: Long
        get() {
            var amount: Long
            var count = 1
            do {
                if (count > 1) {
                    println("\nEnter the valid amount")
                }
                println("\nEnter the loan amount")
                while (!scannerObj.hasNextLong()) {
                    println("Enter the valid amount")
                    scannerObj.next()
                }
                amount = scannerObj.nextLong()
                count++
            } while (amount <= 0)
            return amount
        }

    override fun invalidRequestNotification(cardType: String) {
        if (cardType == "credit") {
            println("\nCredit card access is already available")
        } else if (cardType == "debit") {
            println("\nDebit card access is already available")
        }
    }

    override fun getNewBranchCode(branches: Set<String>): String {
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

    override fun displayBranches(branchesList: Set<String>) {
        println("------------------ALL BRANCHES------------------\n")
        branchesList.forEach() {branch->
            println("Branch Code :$branch")
            println("----------------------------------------------------\n")
        }
    }

    override fun reqAlreadySubmitted() {
        println("\nApplication is already submitted to Manager")
    }

    override fun previousBranchGivenNoti() {
        println("  You entered previous branch code ")
    }
}