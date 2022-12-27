//Secondary constructor will be executed after all the init blocks are executed
//Secondary constructor must call primary constructor
//Secondary constructor is unnecessary because default value can be given primary constructor
package practise

class Person (val firstName:String="No Name given",val secondName:String="No Name given"){
    init{
        println("init 1")
    }
//    val firstName:String
//    val secondName: String
//    init {
//        this.firstName = firstName
//        this.secondName=secondName
//    }
    init{
        println("init 2")
    }
//    constructor():this("No Name given","No Name given"){
//        println("secondary Constructor")
//    }

    override fun toString(): String {
        return "Person\nfirstName: $firstName\nsecondName : $secondName"
    }

}
fun main(){
    val person1 : Person=Person("ram","kumar")
    println(person1)
}