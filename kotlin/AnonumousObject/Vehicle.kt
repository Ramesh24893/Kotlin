package AnonumousObject

open class Vehicle {
    val speed:Int=100
    fun move(){

    }
    private fun owner()=object{
        val name="Ramesh"
        val age=21
    }
    fun printOwnerDetails(){
        val ownerObj= owner()
        println(ownerObj.name)
    }


}
fun  main(){
//    val vehicle=object:Vehicle(){
//
//    }
    val vehicle=Vehicle()
    vehicle.printOwnerDetails()

}
