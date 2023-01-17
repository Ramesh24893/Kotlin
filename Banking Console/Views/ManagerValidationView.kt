package Views

import Model.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.runBlocking
import java.util.*
import kotlin.collections.HashMap

class ManagerValidationView : ManagerValidationUI {
    var scannerObj = Scanner(System.`in`)
    override fun showLoanRequest(loanForm: String): String {
        println(
            """
    ==================================
    $loanForm
    =================================
    """.trimIndent()
        )
        return validateRequest()
    }

    override fun showBranchChangeRequest(branchChangeForm: String): String {
        println(
            """
    =================================
    $branchChangeForm
    =================================
    """.trimIndent()
        )
        return validateRequest()
    }

    override fun showDebitCardRequest(debitCardForm: String): String {
        println(
            """
    =================================
    $debitCardForm
    =================================
    """.trimIndent()
        )
        return validateRequest()
    }

    override fun showCreditCardRequest(creditCardForm: String): String {
        println(
            """
    =================================
    $creditCardForm
    =================================
    """.trimIndent()
        )
        return validateRequest()
    }

    override fun validateRequest(): String {
        var value: String
        var count = 1
        do {
            if (count > 1) {
                println("Enter yes or no")
            }
            println("\nEnter yes to accept request\nEnter no to reject request")
            value = scannerObj.nextLine()
            count++
        } while (!(value.equals("yes", ignoreCase = true) || value.equals("no", ignoreCase = true)))
        return value
    }

    override fun displayAllBranchStats(branches: Flow<Branch>)= runBlocking {

        branches.collect { branch ->
            println(
                """
                **********************************************
                Branch Code       : ${branch.branchCode}
                Branch Name       : ${branch.branchName}
                Branch Profit     : ${branch.branchProfit}
                Reserve Amount    : ${branch.reserveAmount}
                Accounts present  : ${branch.accounts.size}
                **********************************************
                """.trimIndent()
            )
        }
    }

    override fun formAcceptedNotification() {
        println("Application is accepted")
    }

    override fun formRejectedNotification() {
        println("Application is rejected")
    }

    override fun noRequestAvailNotification() {
        println("No Requests received")
    }
}