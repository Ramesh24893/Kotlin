package Classes
interface ANimal{
    val nam:String
}
//data class DataClass(val par:String):ANimal{
//
//}
//class DerivedDataClass:DataClass("ram"){
//
//}

object Student:ANimal{
    val name:String="ram"
    override val nam: String
        get() = TODO("Not yet implemented")


}