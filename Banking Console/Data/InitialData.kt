package Data

import Model.Account
import Model.Branch
import Model.User
import java.time.LocalDate


    fun initialData() {

        val chennaiBranch = Branch("Chennai", 1000000, "ZOHO1000")
        BankDataBase.branches[chennaiBranch.branchCode] = chennaiBranch
        val maduraiBranch = Branch("Madurai", 1000000, "ZOHO1001")
        BankDataBase.branches[maduraiBranch.branchCode] = maduraiBranch
        val coimbatoreBranch = Branch("Coimbatore", 1000000, "ZOHO1002")
        BankDataBase.branches[coimbatoreBranch.branchCode] = coimbatoreBranch
        val tirunelveliBranch = Branch("Tirunelveli", 1000000, "ZOHO1003")
        BankDataBase.branches[tirunelveliBranch.branchCode] = tirunelveliBranch
        val user1 = User("zohoUser@1", "Appx@123")
        val acc = Account("Ram", 90876123456789L, 8610036775L, "ZOHO1001", "Mahesh",
            24, "Male", 823260024788L, "BGLR1232j", "Nellai",LocalDate.now()
        )
        user1.account = acc
        acc.transferLimit = 1000000
        acc.withdrawLimit = 10000
        acc.depositLimit = 1000000
        acc.minBalance = 20000
        acc.overDraftLimit = 50000
        acc.accountType = "CurrentAccount"
        acc.dateOfCreation = LocalDate.now()
        BankDataBase.users[user1.userId] = user1
        BankDataBase.accounts[acc.accountNumber] = acc
        BankDataBase.branches["ZOHO1002"]!!.accounts.add(acc.accountNumber)
        acc.linkedUserId=user1.userId
        val user2 = User("zohoUser@2", "Appx@456")
        val acc2 = Account("Ramesh", 98765432156789L, 8675473099L, "ZOHO1003", "Ganesh", 31,
            "Male", 824560024788L, "AGHR1232j", "Covai", LocalDate.now())
        user2.account = acc2
        acc2.transferLimit = 100000
        acc2.withdrawLimit = 50000
        acc2.depositLimit = 100000
        acc2.minBalance = 1000
        acc2.accountType = "SavingsAccount"
        acc2.dateOfCreation = LocalDate.now()
        BankDataBase.users[user2.userId] = user2
        BankDataBase.accounts[acc2.accountNumber] = acc2
        BankDataBase.branches["ZOHO1002"]!!.accounts.add(acc2.accountNumber)
        acc2.linkedUserId=user2.userId
        val unlinkedAccount = Account(
            "Rajesh",
            98765432101234L,
            8613136775L,
            "ZOHO1002",
            "Suresh",
            24,
            "Male",
            993260024788L,
            "KGHR1232j",
            "Chennai",
            LocalDate.now()
        )
        BankDataBase.accounts[unlinkedAccount.accountNumber] = unlinkedAccount
        BankDataBase.branches["ZOHO1001"]!!.accounts.add(acc.accountNumber)
        unlinkedAccount.transferLimit = 100000
        unlinkedAccount.withdrawLimit = 50000
        unlinkedAccount.depositLimit = 100000
        unlinkedAccount.minBalance = 1000
        unlinkedAccount.accountType = "SavingsAccount"
        unlinkedAccount.dateOfCreation = LocalDate.now()
    }
