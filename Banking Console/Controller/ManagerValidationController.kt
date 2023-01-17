package Controller

import Data.BankDataBase
import Model.Account
import Model.CreditCard
import Model.DebitCard
import Model.Manager
import Views.ManagerValidationUI
import kotlinx.coroutines.flow.flow
import java.time.LocalDate

class ManagerValidationController( private val managerValidaUI: ManagerValidationUI) {

    private val managerObj: Manager = BankDataBase.manager

    fun displayBranchStats() {
        val branch=flow{
            BankDataBase.branches.values.forEach{
                emit(it)
            }
        }
        managerValidaUI.displayAllBranchStats(branch)
    }

    fun validateCreditCardRequests() {
        val creditCardForms = managerObj.creditCardsReq

        if (creditCardForms.isEmpty()) {
            managerValidaUI.noRequestAvailNotification()
            return
        }

        for ((_, creditCardForm) in creditCardForms) {
            val user = BankDataBase.users[creditCardForm.userId]

            if (managerValidaUI.showCreditCardRequest(creditCardForm.toString()).equals("yes", ignoreCase = true)) {

                val accountNumber = creditCardForm.accNum
                generateCreditCard(BankDataBase.accounts[accountNumber])
                user!!.messages.add("Application for credit card is accepted")
                managerValidaUI.formAcceptedNotification()
            }
            else {
                user!!.messages.add("Application for credit card is rejected")
                managerValidaUI.formRejectedNotification()
            }
            creditCardForms.remove(creditCardForm.userId)
        }
    }

    fun validateDebitCardRequests() {
        val debitCardForms = managerObj.debitCardsReq

        if (debitCardForms.isEmpty()) {
            managerValidaUI.noRequestAvailNotification()
            return
        }

        for ((_, debitCardForm) in debitCardForms) {
            val user = BankDataBase.users[debitCardForm.userId]
            if (managerValidaUI.showDebitCardRequest(debitCardForm.toString()).equals("yes", ignoreCase = true)) {
                val accountNumber = debitCardForm.accNum
                generateDebitCard(BankDataBase.accounts[accountNumber])
                user!!.messages.add("Application for debit card is accepted")
                managerValidaUI.formAcceptedNotification()
            }
            else {
                user!!.messages.add("Application for debit card is rejected")
                managerValidaUI.formRejectedNotification()
            }
            debitCardForms.remove(debitCardForm.userId)
        }
    }

    fun validateBranchChangeRequests() {
        val branchChangeForms = managerObj.branchChangeReq

        if (branchChangeForms.isEmpty()) {
            managerValidaUI.noRequestAvailNotification()
            return
        }

        for ((_, branchChangeForm) in branchChangeForms) {
            val user = BankDataBase.users[branchChangeForm.userId]

            if (managerValidaUI.showBranchChangeRequest(branchChangeForm.toString()).equals("yes", ignoreCase = true)) {
                val account = BankDataBase.accounts[branchChangeForm.accountNumber]
                account!!.branchCode = branchChangeForm.newBranchCode
                val currentBranch = BankDataBase.branches[branchChangeForm.currentBranchCode]
                val newBranch = BankDataBase.branches[branchChangeForm.newBranchCode]
                currentBranch!!.accounts.remove(branchChangeForm.accountNumber)
                newBranch!!.accounts.add(branchChangeForm.accountNumber)
                user!!.messages.add("Application for branch is accepted and Branch is changed")
                managerValidaUI.formAcceptedNotification()
            }
            else {
                user!!.messages.add("Application for branch is accepted and Branch is changed")
                managerValidaUI.formRejectedNotification()
            }
            branchChangeForms.remove(branchChangeForm.userId)
        }
    }

    fun validateLoanRequests() {
        val loanForms = managerObj.loansReq
        if (loanForms.isEmpty()) {
            managerValidaUI.noRequestAvailNotification()
            return
        }
        for ((_, loanForm) in loanForms) {
            val user = BankDataBase.users[loanForm.userId]
            if (managerValidaUI.showLoanRequest(loanForm.toString()).equals("yes", ignoreCase = true)) {
                val accNum = loanForm.accNumber
                val amount = loanForm.amount
                val account = BankDataBase.accounts[accNum]
                val branch = BankDataBase.branches[account!!.branchCode]
                account.balance = account.balance + amount
                branch!!.reserveAmount = branch.reserveAmount - amount
                user!!.messages.add("Application for loan is accepted")
                managerValidaUI.formAcceptedNotification()
            }
            else {
                user!!.messages.add("Application for loan is rejected")
                managerValidaUI.formRejectedNotification()
            }
            loanForms.remove(loanForm.userId)
        }
    }

    fun generateCreditCard(account: Account?) {
        val date = LocalDate.now().plusYears(10)
        val creditCard = CreditCard(generateCardNum(), date, generateCCV()) //add bank name in credit card
        account!!.creditCard = creditCard
    }

    fun generateDebitCard(account: Account?) {
        val date = LocalDate.now().plusYears(10)
        val debitCard = DebitCard(generateCardNum(), date, generateCCV()) //add bank name in credit card
        account!!.debitCard=debitCard
    }

    fun generateCardNum(): Long {
        val max = 100000000000000L
        val min = 10000000000000L
        return (Math.random() * (max - min + 1) + max).toLong()
    }

    fun generateCCV(): Int {
        val max = 1000
        val min = 100
        return (Math.random() * (max - min + 1) + max).toInt()
    }
}