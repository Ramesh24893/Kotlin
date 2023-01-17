package Views

interface LoginManagerUI {
    val managerUserNameForValidation: String
    val managerPasswordForValidation: String
    fun invalidManagerLoginNotification()
    fun invalidDataNotification()
}