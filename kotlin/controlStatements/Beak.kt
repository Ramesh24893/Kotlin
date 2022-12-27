package controlStatements

fun main(){
    breakLoop@ for(i in 1..3){
        for(j in 1 .. 3 ){
            println("$i :  $j")
            if(i==2 && i==2){
                break@breakLoop
            }
        }
    }
}