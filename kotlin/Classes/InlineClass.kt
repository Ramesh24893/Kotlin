package Classes
@JvmInline
value class Width(val width:Int)
@JvmInline
value class Height(val height:Int)

class Rectangle(val width:Width,val height:Height)
fun main(){
    val width=Width(10)
    val height=Height(10)
    val rectangle=Rectangle(width,height)

}