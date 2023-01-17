package Views

import Model.*
import kotlinx.coroutines.flow.Flow

interface ManagerValidationUI {

    fun showLoanRequest(loanForm: String): String

    fun showBranchChangeRequest(branchChangeForm: String): String

    fun showDebitCardRequest(debitCardForm: String): String

    fun showCreditCardRequest(creditCardForm: String): String

    fun validateRequest(): String

    fun displayAllBranchStats(branches: Flow<Branch>)

    fun formAcceptedNotification()

    fun formRejectedNotification()

    fun noRequestAvailNotification()
}