fun main(){
    greeting(message="How are you",
        "Ram")
}
fun greeting(message:String,name: String?="User" ,reps : Int=3){
    for(i:Int in 0 until reps)println("Hi $name $message ")
}
fun greetings(message:String,name: String ,reps : Int){
    for(i:Int in 0 until reps)println("Hi $name $message ")
}