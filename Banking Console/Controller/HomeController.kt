package Controller


import Views.*

class HomeController {
    companion object {
        fun invokeHomeController() {


        // val bankDataObj: BankDataBase = BankDataBase.instance
        val userInputUI: UserInputUI = UserInputView()
        val logUserUI: LoginUserUI = LoginUserView()
        var flow = true
        val bankLogoUI = BankLogoView()
        val userController = UserController()
        bankLogoUI.displayLogo()
        while (flow)
        {
            when (HomeView().showHomeView()) {
                1 -> {
                    val loginUserContObj = LoginUserController(logUserUI)
                    val userObject = loginUserContObj.login()
                    userController.showUserFeatures(userInputUI, userObject)
                }

                2 -> ManagerController().showManagerFeatures()

                3 -> {
                    val userRegUI: UserRegistrationUI = UserRegistrationView()
                    val userRegisObj = UserRegistrationController(userRegUI,)
                    val userObj = userRegisObj.register()
                    userController.showUserFeatures(userInputUI, userObj)
                }

                4 -> flow = false
            }
        }
    }
}
//    BankDataBase bankDataObj = BankDataBase.getInstance();
//
//    UserInputUI userInputUI = new UserInputView();
//    LoginUserUI logUserUI = new LoginUserView();
//
//    boolean flow = true;
//
//    BankLogoView bankLogoUI = new BankLogoView();
//    bankLogoUI.displayLogo();
//    //BankLogoView obj=new BankLogoView();
//
//
//    while (flow) {
//        switch (new HomeView().showHomeView()) {
//
//            case 1:
//            LoginUserController loginUserContObj = new LoginUserController(bankDataObj, logUserUI);
//            User userObject = loginUserContObj.login();
//
//            UserController.showUserFeatures(bankDataObj, userInputUI, userObject);
//            break;
//
//            case 2:
//            ManagerController.showManagerFeatures(bankDataObj);
//            break;
//
//            case 3:
//            UserRegistrationUI userRegUI = new UserRegistrationView();
//            UserRegistrationController userRegisObj = new UserRegistrationController(userRegUI, bankDataObj);
//
//            User userObj = userRegisObj.register();
//            UserController.showUserFeatures(bankDataObj, userInputUI, userObj);
//            break;
//
//            case 4:
//            flow = false;}}}
//    fun invokeHomeController1(){
//    val bankDataObj: BankDataBase = BankDataBase.instance
//    val userInputUI: UserInputUI = UserInputView()
//    val logUserUI: LoginUserUI = LoginUserView()
//    var flow = true
//    val bankLogoUI = BankLogoView()
//    val userController=UserController()
//    val homePageObj:HomePageUI=HomeView()
//    bankLogoUI.displayLogo()
//        while(flow){
//            when(homePageObj.showHomeView()){
//                1 ->
//
//            }
//        }
//    }
}