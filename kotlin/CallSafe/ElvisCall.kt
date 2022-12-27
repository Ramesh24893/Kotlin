package CallSafe

fun main(){
    val name :String?=null
    println(
        if(name==null)null
        else "no name")
}

fun main1(){
    val name :String?="Ram"
    val length=name?.length?:-1
    print(length)
}