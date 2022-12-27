package practise

interface PersonInfoProvider {
    val name:String
    fun printInfo(){
       println("Interface PersonInfo Provider")
    }
}
interface SessionInfoProvider{
    fun getSessionId()
}
class BasicInfoProvider: PersonInfoProvider,SessionInfoProvider{

    override val name:String
        get()="hi"

    override fun printInfo() {
        super.printInfo()

        println("Helo")
    }

    override fun getSessionId() {

        println("This is sessionId")
    }
}
fun main(){
        val person=BasicInfoProvider()
    person.printInfo()
    person.getSessionId()
}