package Controller

import Data.BankDataBase
import Model.*
import Views.UserRequestUI

class UserRequestController( private val userRequestUI: UserRequestUI) {
    private val managerObj: Manager=BankDataBase.manager


    fun applyForCreditCard(account: Account, userObj: User) {
        if (managerObj.creditCardsReq.containsKey(userObj.userId)) {
            userRequestUI.reqAlreadySubmitted()
            return
        }
        if (account.creditCard == null) {
            val generatedForm = generateCreditCardForm(account, userObj.userId)
            submitCreditCardForm(generatedForm, userObj.userId)
            userRequestUI.requestSubmissionNotification("credit")
            userObj.messages.add("Your application for credit card is submitted")
        }
        else {
            userRequestUI.invalidRequestNotification("credit")
        }
    }

    fun applyForDebitCard(account: Account, userObj: User) {
        if (managerObj.debitCardsReq.containsKey(userObj.userId)) {
            userRequestUI.reqAlreadySubmitted()
            return
        }
        if (account.debitCard == null) {
            val generatedForm = generateDebitCardForm(account, userObj.userId)
            submitDebitCardForm(generatedForm, userObj.userId)
            userRequestUI.requestSubmissionNotification("debit")
            userObj.messages.add("Your application for debit card is submitted")
        }
        else {
            userRequestUI.invalidRequestNotification("debit")
        }
    }

    fun applyForLoan(account: Account, userObj: User) {
        if (managerObj.loansReq.containsKey(userObj.userId)) {
            userRequestUI.reqAlreadySubmitted()
            return
        }
        val generatedLoanForm = generateLoanForm(account, userObj.userId)
        submitLoanForm(generatedLoanForm, userObj.userId)
        userRequestUI.requestSubmissionNotification("loan")
        userObj.messages.add("Application for loan is submitted")
    }

    fun applyForBranchChange(account: Account, userObj: User, branchesList: Set<String>) {
        if (managerObj.branchChangeReq.containsKey(userObj.userId)) {
            userRequestUI.reqAlreadySubmitted()
            return
        }
        userRequestUI.displayBranches(branchesList)
        val accountNumber = account.accountNumber
        val currentBranchCode = account.branchCode
        val newBranchCode = userRequestUI.getNewBranchCode(BankDataBase.branches.keys)
        if (currentBranchCode == newBranchCode) {
            userRequestUI.previousBranchGivenNoti()
            return
        }
        val branchChangeForm = generateBranchChangeForm(accountNumber, currentBranchCode, newBranchCode, userObj.userId)
        submitBranchChangeForm(branchChangeForm, userObj.userId)
        userRequestUI.requestSubmissionNotification("branchChange")
        userObj.messages.add("Application for branch change is submitted")
    }

    private fun generateCreditCardForm(account: Account, userName: String): CreditCardForm {
        val accNum = account.accountNumber
        val branchCode = account.branchCode
        val accHolderName = account.accHolderName
        return CreditCardForm(accNum, branchCode, account.accountType, accHolderName, userName)
    }

    private fun generateDebitCardForm(account: Account, userId: String): DebitCardForm {
        val accNum = account.accountNumber
        val branchCode = account.branchCode
        val accHolderName = account.accHolderName
        return DebitCardForm(accNum, branchCode, account.accountType, accHolderName, userId)
    }

    private fun generateLoanForm(account: Account, userId: String): LoanForm {
        val amount = userRequestUI.loanAmount
        return LoanForm(account.accountNumber, account.branchCode, amount, userId)
    }

    private fun generateBranchChangeForm(
        accountNumber: Long,
        currentBranchCode: String,
        newBranchCode: String?,
        userId: String
    ): BranchChangeForm {
        return BranchChangeForm(accountNumber, currentBranchCode, newBranchCode!!, userId)
    }

    private fun submitLoanForm(generatedLoanForm: LoanForm, userId: String) {
        managerObj.loansReq[userId] = generatedLoanForm
    }

    private fun submitBranchChangeForm(branchChangeForm: BranchChangeForm, userId: String) {
        managerObj.branchChangeReq[userId] = branchChangeForm
    }

    private fun submitCreditCardForm(generatedCreditCardForm: CreditCardForm, userId: String) {
        managerObj.creditCardsReq[userId] = generatedCreditCardForm
    }

    private fun submitDebitCardForm(generatedDebitCardForm: DebitCardForm, userId: String) {
        managerObj.debitCardsReq[userId] = generatedDebitCardForm
    }
}