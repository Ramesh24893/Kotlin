package Exception

import java.lang.Exception

fun main(){
    val num=try{
        10/0

    }catch(e: Exception){
        "hello"
        "hi"
        "one"
        1
        2
        3

    }finally{
        2
    }
    print(num)
}