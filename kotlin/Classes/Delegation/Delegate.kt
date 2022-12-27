package Classes.Delegation

interface Bird{
    fun flyAndFindFood()
}
class Crow(private val bird:Bird):Bird {
    //by bird
    override fun flyAndFindFood() {
        bird.flyAndFindFood()
    }

}
class Pigeon():Bird{
    override fun flyAndFindFood() {
        println("Pigeon is flying and finding food")
    }

}


fun main(){
    val pigeon=Pigeon()
    val crow=Crow(pigeon)
    crow.flyAndFindFood()
}