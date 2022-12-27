package LambdaAndHigherOrderFunction
interface Execute{
    fun execute(sum:Int)

}
class Add{
    fun addTwoNum(num1:Int,num2:Int){
        println(num1+num2)
    }
    fun addTwoNum(num1:Int,num2:Int,action:Execute){   //Using anonymous object (Object Expression)
        action.execute(num1+num2)
    }
    fun addTwoNum(num1:Int,num2:Int,action:(Int)->Unit){  //Using Lambda function
        action(num1+num2)
    }
}

fun main(){
    val add=Add()
    add.addTwoNum(3,4)
    add.addTwoNum(3,6,object:Execute{
        override fun execute(sum:Int){
            println(sum)
        }

    })
    val myLambda:(Int,Int)->Unit={it,io-> println(it) }

    add.addTwoNum(4,23) { it -> println(it) }
}