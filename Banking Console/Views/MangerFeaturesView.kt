package Views

import java.util.*

class MangerFeaturesView : ManagerFeaturesUI {
    override fun managerMenuView(): Int {
        val scannerObj = Scanner(System.`in`)
        var count = 1
        do {
            if (count > 1) {
                scannerObj.next()
                println("Enter valid data")
            }
            println(
                """
    ===============================================
    ||           Manager Features                ||
    ===============================================
    ||       1. Show Branches stats              ||
    ||       2. Validate credit card requests    ||
    ||       3. Validate debit card requests     ||
    ||       4. Validate loan requests           ||
    ||       5. Validate branch change requests  ||
    ||       6. Exit                             ||
    ===============================================
    """.trimIndent()
            )
            count++
        } while (!scannerObj.hasNextInt())
        return scannerObj.nextInt()
    }
}