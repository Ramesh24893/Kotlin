package Controller

import Data.BankDataBase
import Views.*

class ManagerController {
    fun showManagerFeatures() {

        val loginManagerUI: LoginManagerUI = LoginManagerView()
        val loginManagerContObj = LoginManagerController(loginManagerUI)
        val managerValidUI: ManagerValidationUI = ManagerValidationView()
        val managerControllerObj = ManagerValidationController(managerValidUI)
        if (loginManagerContObj.login()) return
        var flow = true

        while (flow) {

            when (MangerFeaturesView().managerMenuView()) {

                1 -> managerControllerObj.displayBranchStats()

                2 -> managerControllerObj.validateCreditCardRequests()

                3 -> managerControllerObj.validateDebitCardRequests()

                4 -> managerControllerObj.validateLoanRequests()

                5 -> managerControllerObj.validateBranchChangeRequests()

                6 -> flow = false

                else -> loginManagerUI.invalidDataNotification()
            }
        }
    }
}