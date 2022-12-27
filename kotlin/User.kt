class User(val name:String){
    override fun toString(): String {
        return "User(name='$name')"
    }
}
fun main(){
    val user1=User("Ramesh")
    println(user1.name)
}