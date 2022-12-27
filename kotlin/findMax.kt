fun findMax(num1:Int, num2:Int): Int {
    val max=if(num1>num2) num1 else num2
    return max
}
fun main(){
    println(findMax(10,12))
}