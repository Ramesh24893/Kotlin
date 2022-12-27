fun findMaximum(a: Int, b: Int)= if(a>b) a else b
    //return if(a>b) a else b
fun findMaximum(a:Int,b:Int,c:Int)=when{
    a>b && a>c -> a
        b>c && b>a -> b
        else -> c
}
fun greet(count:Int){
    for(num:Int in 0 until count )
        println("Hell $num")
}
fun main() {
   val a:Int = findMaximum(4,5,45)
        println(a)
    greet(9)
}

fun funOverLoadingOrder(a:Int,b:String){

}
fun funOverLoadingOrder(a:String,b:Int){

}


