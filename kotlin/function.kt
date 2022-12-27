fun showMessage():String?{
    println("Hello")
    return null
}
fun showMess():String?=null
fun showNotification()=null
fun printMessage(name:String){
    val mess ="Hi "+ name
    val message="Hi  $name"
    println(message)
}
fun main(){
    showMessage()
    println(showMessage())
    println(showNotification())
    println(showMess())
    println(showMess())
    printMessage("Ramesh")
}