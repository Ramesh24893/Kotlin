package practise

class Person1 (val firName:String="No Name",val secName:String="No Name"){
    val friendsNickName:String?=null
//        set(value) {
//            field=value
//        }
        get(){
            print("getter")
            return field
        }

    //setter is not available VAL
    init{                             // getter and setter available only for VAR

    }
//        set(value){
//
//        }
    var nickName:String?=null
    set(value) {
        field=value
    }
    get(){
        return field
    }

    fun getInfo(){
        val nickNameToPrint=nickName ?:"no Nick Name"
        println("$firName \n$secName \n$nickNameToPrint")
    }

    override fun toString(): String {
        return "Person1(firName='$firName', secName='$secName', friendsNickName=$friendsNickName, nickName=$nickName)"
    }


}
fun main(){

    val person1=Person1()
    println(person1)
    person1.getInfo()



}
