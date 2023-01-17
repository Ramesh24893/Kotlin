package Controller

import Data.BankDataBase
import Model.Account
import Model.User
import Views.AccountUI
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

internal class AccountController( private val accProUI: AccountUI) {


    fun initiateCurrentAccountCreation(userObj: User, branchesList: Flow<String>) {
        accProUI.displayBranches(branchesList)
        val branch = accProUI.getBranchCode(BankDataBase.branches.keys)
        createCurrentAccount(userObj, branch)
        accProUI.accCreationSuccessfulNotification()
    }

    fun initiateSavingsAccountCreation(userObj: User, branchesList: Flow<String>) {
        accProUI.displayBranches(branchesList)
        val branch = accProUI.getBranchCode(BankDataBase.branches.keys)
        createSavingsAccount(userObj, branch)
        accProUI.accCreationSuccessfulNotification()
    }

    fun initiateLinkWithExistingBankAccount(user: User): Boolean {
        if (linkWithExistingBankAccount(user)) {
            accProUI.existingAccountLinkingSuccessful()
            return true
        } else accProUI.existingAccountLinkingFailed()
        return false
    }

    fun deleteAccount(user: User, account: Account) {
        user.account = null
        BankDataBase.accounts.remove(account.accountNumber)
        accProUI.accDeletionMessage()
    }

    fun createCurrentAccount(userObj: User, branchCode: String) {
        val name = accProUI.name
        val mobNum = accProUI.mobileNum
        val father = accProUI.fathersName
        val age = accProUI.age
        val gender = accProUI.gender
        val city = accProUI.cityName
        val aadhaar = accProUI.aadhaarNumber
        val pan = accProUI.panNumber
        val accObj = Account(
            name,
            generateAccountNumber(),
            mobNum,
            branchCode,
            father,
            age,
            gender,
            aadhaar,
            pan,
            city,
            LocalDate.now()
        )
        updateBankAccount(userObj.userId, "CurrentAccount", LocalDate.now(), accObj)
        setCurrentAccTransLimits(accObj)
        updateBankData(accObj, branchCode)
        updateUserAcc(userObj, accObj)
    }

    private fun setCurrentAccTransLimits(accObj: Account) {
        accObj.transferLimit = 1000000
        accObj.withdrawLimit = 20000
        accObj.depositLimit = 1000000
        accObj.minBalance = 20000
        accObj.overDraftLimit = 50000
    }

    fun createSavingsAccount(userObj: User, branchCode: String?) {
        val name = accProUI.name
        val mobNum = accProUI.mobileNum
        val father = accProUI.fathersName
        val age = accProUI.age
        val gender = accProUI.gender
        val city = accProUI.cityName
        val aadhaar = accProUI.aadhaarNumber
        val pan = accProUI.panNumber
        val accObj = Account(
            name,
            generateAccountNumber(),
            mobNum,
            branchCode!!,
            father,
            age,
            gender,
            aadhaar,
            pan,
            city,
            LocalDate.now()
        )
        setSavingsAccTransLimits(accObj)
        updateBankAccount(userObj.userId, "SavingsAccount", LocalDate.now(), accObj)
        updateBankData(accObj, branchCode)
        updateUserAcc(userObj, accObj)
    }

    private fun setSavingsAccTransLimits(accObj: Account) {
        accObj.transferLimit = 100000
        accObj.withdrawLimit = 50000
        accObj.depositLimit = 100000
        accObj.minBalance = 1000
        accObj.overDraftLimit = 0
    }

    private fun updateBankAccount(userID: String, accType: String, date: LocalDate, accObj: Account) {
        accObj.accountType = accType
        accObj.dateOfCreation = date
        accObj.linkedUserId = userID
    }

    private fun updateBankData(acc: Account, branchCode: String?) {
        BankDataBase.accounts[acc.accountNumber] = acc
        BankDataBase.branches[branchCode]!!.accounts.add(acc.accountNumber)
    }

    private fun updateUserAcc(userObj: User, accObj: Account) {
        userObj.account = accObj
    }

    fun linkWithExistingBankAccount(userObj: User): Boolean {
        val name = accProUI.name
        val mobNum = accProUI.mobileNum
        val accountNumber = accProUI.existingAccountNumber

        for ((_, accObj) in BankDataBase.accounts) {
            if (accObj.accHolderName == name && accObj.mobileNumber == mobNum && accObj.accountNumber == accountNumber && accObj.linkedUserId == "") {
                userObj.account = accObj
                accObj.linkedUserId = userObj.userId
                return true
            }
        }
        return false
    }

    private fun generateAccountNumber(): Long {
        val max = 10000000000000000L
        val min = 1000000000000000L
        return (Math.random() * (max - min + 1) + min).toLong()
    }
}