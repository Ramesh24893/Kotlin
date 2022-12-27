package controlStatements

fun main(){
    val name:String
    name="hello"
    breakLoop@ for(i in 1..3){
        for(j in 1 .. 3 ){
            println("$i :  $j")
            print("   $")
            if(i==2 && i==2){
                continue@breakLoop
            }
        }
    }
}