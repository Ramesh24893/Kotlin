package Views

import Model.User

interface UserRegistrationUI {

    val newUserName: String

    val newPassword: String

    fun userRegisteredNotification(user: User)

    fun userIdExistNotification()
}