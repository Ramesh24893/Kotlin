var age:Int? = null 
fun main(args: Array<String>) {
    //println("Hello World!")

    val name: String="Ramesh"
    println(name)
    age=22
    println(age)
    if(age==22){
        println("You are eligible for achieving great things")
    }
    when(age){
        21-> println("Hello")
        else->println("Hi")
    }


}