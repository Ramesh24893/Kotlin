package Exception


import java.util.Scanner

class IllegalVoterException (message:String):Exception(message){
}

fun main(){
    println("Enter your age")

    val age:Int= 12
    if(age < 18){
        throw IllegalVoterException("You are younger")
    }
}
