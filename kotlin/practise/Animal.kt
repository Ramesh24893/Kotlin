package practise

open class Animal {
    protected open val age=21
}

open class Tiger: Animal() {
    override val age=22
    init{
        println(age)
    }
    protected open fun eat(): String{
        return "eating"
    }
}

fun main(){
    val animal1=Animal()
    //animal1.age

}
class Lion(): Animal(){
    val ani=Lion()
    fun cal(){
        ani.age
    }
}