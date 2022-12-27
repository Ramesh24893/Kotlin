package Classes.Generics

class ArrayUtil(private val array:Array<Int>){
    fun findElement(element: Int):Int{
        for(i in array.indices){
            if(array[i]==element){
                return i
            }

        }
        return -1
    }
}
fun main(){
    val arr=GenArrayUtil<Int>(arrayOf(1,2,34,53,54))
    print( arr.findElement(53))
}

fun<T> genFindElement(array:Array<T>,element: T):Int{
    for(i in array.indices){
        if(array[i]==element){
            return i
        }

    }
    return -1
}
class GenArrayUtil<T>(private val array:Array<T>){
    fun findElement(element: T):Int{
        for(i in array.indices){
            if(array[i]==element){
                return i
            }

        }
        return -1
    }
}

