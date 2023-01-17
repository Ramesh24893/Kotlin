package Controller

import Data.BankDataBase
import Model.User
import Views.*
import kotlinx.coroutines.flow.flow


class UserController {
     fun showUserFeatures(userInputUI: UserInputUI, userObject: User?) {
        val accProUI: AccountUI = AccountView()
        val accController = AccountController( accProUI)
        val rateCalc: TransactionTaxCalculator = TaxCalcController()
        val taxDebitContObj = TaxDebiterController( rateCalc)
        val transUI: TransactionUI = TransactionView()
        val transDataGeneObj = TransactionDataGenerator()
        val userRequestUI: UserRequestUI = UserRequestView()
        val userReqContObj = UserRequestController( userRequestUI)
        val userFeaturesUI: UserFeaturesUI = UserFeaturesView()
        if (userObject == null) {
            return
        }
        val branchesList: Set<String> = BankDataBase.branches.keys
        val branches=flow{
            branchesList.forEach{
                emit(it)
            }
        }
        if (userObject.account == null) {
            var loop = true
            while (loop) {
                when (userFeaturesUI.accountSelectionView()) {
                    1 -> {
                        accController.initiateCurrentAccountCreation(userObject, branches)
                        loop = false
                    }

                    2 -> {
                        accController.initiateSavingsAccountCreation(userObject, branches)
                        loop = false
                    }

                    3 -> {
                        if (!accController.initiateLinkWithExistingBankAccount(userObject)) return
                        loop = false
                    }

                    4 -> return
                    else -> userFeaturesUI.invalidDataNotification()
                }
            }
        }
        val account = userObject.account
        var flow = true
        while (flow) {
            val interestCalcObj = object : TransactionTaxCalculator {
                private val accountToAccountTaxRate = 0.003f
                private val depositTaxRate = 0.002f
                private val withdrawTaxRate = 0.005f

                override fun calcWithDrawTax(amount: Int): Int {
                    return (amount * withdrawTaxRate).toInt()
                }

                override fun calcDepositTax(amount: Int): Int {
                    return (amount * depositTaxRate).toInt()
                }

                override fun calcAccountToAccountTransferTax(amount: Int): Int {
                    return (amount * accountToAccountTaxRate).toInt()
                }
            }
            when (userFeaturesUI.userMenuView()) {
                1 -> {
                    val withdrawContObj =
                        WithDrawController(taxDebitContObj, transUI, transDataGeneObj,  interestCalcObj)

                        withdrawContObj.initiateWithdraw(account!!)

                }

                2 -> {
                    val depositContObj =
                        DepositController(taxDebitContObj, transUI, transDataGeneObj, )
                        depositContObj.initiateDeposit(account!!)

                }

                3 -> {
                    val accTransContObj = OnlineTransferController(taxDebitContObj, transUI, transDataGeneObj,  interestCalcObj)
                    accTransContObj.initiateOnlineTransfer(account!!)
                }
                4 -> userReqContObj.applyForCreditCard(account!!, userObject)

                5 -> userReqContObj.applyForDebitCard(account!!, userObject)

                6 -> userReqContObj.applyForLoan(account!!, userObject)

                7 -> userReqContObj.applyForBranchChange(account!!, userObject, branchesList)

                8 -> {
                    accController.deleteAccount(userObject, account!!)
                    return
                }

                9 ->  transUI.displayAllTransactions(flow{
                    account!!.transactions.forEach{
                        emit(it)
                    }
                })

                10 -> userInputUI.displayAccountStatus(account.toString())

                11 -> userInputUI.displayMessages(userObject.messages)

                12 -> userInputUI.displayAvailableBalance(account!!.balance)

                13 -> flow = false

                else -> userFeaturesUI.invalidDataNotification()
            }
        }
    }
}