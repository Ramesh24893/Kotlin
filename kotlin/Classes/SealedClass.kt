package Classes

sealed class Shape{
    data class Rectangle(val length:Int,val breadth:Int):Shape()
    data class Square(val side:Int):Shape(){

    }
    object Circle:Shape()


}
fun checkShape(shape:Shape){
    when(shape){
        is Shape.Square-> println()
        is Shape.Rectangle-> println()
        Shape.Circle-> println()
        is Rhombus->println()
        //else -> println()
       // else -> {}
    }
}
fun main(){
    val shape=Shape.Rectangle(21,34)
    checkShape(shape)
}
