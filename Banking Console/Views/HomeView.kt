package Views

import java.util.*

class HomeView : HomePageUI {
    override fun showHomeView(): Byte {
        val scannerObj = Scanner(System.`in`)
        var count = 1
        do {
            if (count > 1) {
                scannerObj.next()
                println("Enter valid data")
            }
            println("\n||*******************************************************************************||"+
                    "\n||                                                                               ||" +
                    "\n||                             1. User                                           ||"+
                    "\n||                             2. Manager                                        ||"+
                    "\n||                             3. Register User                                  ||"+
                    "\n||                             4. Exit                                           ||"+
                    "\n||                                                                               ||" +
                    "\n||===============================================================================||")

            count++
        } while (!scannerObj.hasNextByte())
        return scannerObj.nextByte()
    }
}