package Views

import java.util.*

class UserFeaturesView : UserFeaturesUI {
    override fun userMenuView(): Byte {
        var count = 1
        do {
            if (count > 1) {
                scannerObj.next()
                println("Enter valid data")
            }
            println(
                """
    
    
    ===========================================
    ||           User Features                ||
    ============================================
    ||       1. Withdraw                      ||
    ||       2. Deposit                       ||
    ||       3. Transfer                      ||
    ||       4. Apply  Credit Card            ||
    ||       5. Apply Debit Card              ||
    ||       6. Apply Loan                    ||
    ||       7. Change Branch                 ||
    ||       8. Delete account                ||
    ||       9. Show Transaction History      ||
    ||       10. Account status               ||
    ||       11. Open Inbox                   ||
    ||       12. Balance Enquiry              ||
    ||       13. Exit                         ||
    ===========================================
    """.trimIndent()
            )
            count++
        } while (!scannerObj.hasNextByte())
        return scannerObj.nextByte()
    }

    override fun accountSelectionView(): Byte{
        var count = 1
        do {
            if (count > 1) {
                scannerObj.next()
                println("Enter valid data")
            }
            println("\n\n1. Create new Current Account ")
            println("2. Create new Savings Account")
            println("3. Link with existing account")
            println("4. Exit")
            count++
        } while (!scannerObj.hasNextByte())
        return scannerObj.nextByte()
    }

    override fun invalidDataNotification() {
        println("\nEnter valid data")
    }

    companion object {
        var scannerObj = Scanner(System.`in`)
    }
}