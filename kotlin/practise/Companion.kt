package practise
interface EntityInterface{
    val id:String
    fun getId()
}

open class ParentEntity{
    open fun getMessage(){

    }
}

open class Test(){
    open fun test(){

    }
}

open class Entity : ParentEntity(){//private constructor(){

    override fun getMessage(){

    }
    companion object{
       // override fun test(){

      //   }
        fun printMessage(){
            println("print Message method")
        }

         val id: String
            get() = TODO("Not yet implemented")

         fun getId() {
            TODO("Not yet implemented")
        }
    }
     open fun printMessage(){

     }
  //  private constructor() : this("name")
}

class childEntity:Entity(){
    override fun printMessage(){

    }
}
fun main(){
    val ent=Entity.printMessage()
    //Entity.printMessage()
}