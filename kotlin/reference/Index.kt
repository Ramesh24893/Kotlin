package reference

fun main(){
    val arr= listOf("one","two","three")
    for(index in arr.indices){
        println("$index : ${arr[index]}")
    }
}