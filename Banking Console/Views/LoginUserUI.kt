package Views

interface LoginUserUI {

    val userNameForValidation: String

    val userPasswordForValidation: String

    fun inValidUserNotification()

    fun noSuchUserNotification()
}