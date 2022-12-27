package Classes

abstract  class Human(open var name:String){

    abstract fun think()
}
class Doctor(override var name: String) : Human("Ram"){
    //override var name:String
    override fun think(){

    }
}
class Teacher: Human("Raj"){
     override var name: String
        get() = TODO("Not yet implemented")
        set(value) {}

    override fun think(){

    }
}
class Animal
fun main(){
    val ani=Animal()
}