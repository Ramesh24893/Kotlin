package Data

import Model.Account
import Model.Branch
import Model.Manager
import Model.User

object BankDataBase {
    val users = HashMap<String, User>()
    val branches = HashMap<String, Branch>()
    val accounts = HashMap<Long, Account>()
    val manager: Manager = Manager()

}