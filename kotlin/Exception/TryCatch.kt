package Exception

fun main(){
    val num1:Int=10
    val num2:Int=0
    try{
        num1/num2
    }catch(e:Exception){
        e.printStackTrace()
    }finally{

    }
}