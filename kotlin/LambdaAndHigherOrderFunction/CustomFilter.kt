package LambdaAndHigherOrderFunction

interface Shape{
    fun area():Int
}

class Rectangle(private val length:Int, private val breadth:Int):Shape{
    override fun area():Int{
        return length*breadth
    }
}
class Triangle(private val height:Int, private val breadth:Int):Shape{
    override fun area():Int{
        return (height*breadth)/2
    }
}
class Square(private val side:Int):Shape{
    override fun area():Int{
        return side*side
    }
}
fun List<Shape>.customFilter(filterFunction:(Shape)->Boolean):List<Shape>{
    val filteredList= mutableListOf<Shape>()
    for(shape in this){
        if(filterFunction(shape)){
            filteredList.add(shape)
        }
    }
    return filteredList

}

fun<T> List<T>.CustomFilter(filterFunction:(T)->Boolean):List<T>{
    val filteredList= mutableListOf<T>()
    for(item in this){
        if(filterFunction(item)){
            filteredList.add(item)
        }
    }
    return filteredList

}

fun main(){
    val rec=Rectangle(10,10)
    val tri=Triangle(15,20)
    val sqr=Square(12)
    val shapes=listOf(rec,tri,sqr)
    val filtered=shapes.customFilter { it.area()>10 }.sortedBy { it.area() }
    filtered.forEach{ println(it.area()) }

}