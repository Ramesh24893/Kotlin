package Classes.Property

class Human(age:Int){
    private var _age:Int=age
    var age: Int //(= age) //by default public
        get(){
            return _age
        }
        set(value){
            _age=value
        }

}

class Student{

    private val _hobbies =mutableListOf<String>()   //Here I can add hobbies but cant delete hobbies because this is my application requirement
    val hobbies: List<String>
        get(){
            return _hobbies
        }
    fun addHobby(hobbyName:String){
        _hobbies.add(hobbyName)
    }
}

fun main(){
    val human=Human(19)
    human.age
}