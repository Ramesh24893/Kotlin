package CallSafe

fun main(){
    val name:String?=null
    name?.let{
        println("The length of the name is ${name.length}")
    }
}