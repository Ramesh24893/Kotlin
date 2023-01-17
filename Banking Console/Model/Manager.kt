package Model

data class Manager(
     val managerUserName: String = "reeganth",
    val managerPassword: String = "24893",
    val creditCardsReq: HashMap<String, CreditCardForm> = HashMap<String, CreditCardForm>(),
     val debitCardsReq: HashMap<String, DebitCardForm> = HashMap<String, DebitCardForm>(),
    val loansReq: HashMap<String, LoanForm> = HashMap<String, LoanForm>(),
    val branchChangeReq: HashMap<String, BranchChangeForm> = HashMap<String, BranchChangeForm>(),
)