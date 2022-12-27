fun main(){
    var array:IntArray=intArrayOf(1,2,4,5)
    getSum(1,34,34,2,*array,43,43,  afterVarArgs =2) //----   *spread operator
}

fun  getSum(vararg num:Int,  afterVarArgs:Int){

}

fun getSum(vararg numbers: Int){ //a function can have only one single var args
    var sum=0;
    for(num:Int in numbers)sum+=num
    println(sum)
}