package Classes.Enum

interface ICardCashBack{
    fun getCashBackrate() :Double
}
enum class CreditCardType(color:String,limit:Int=10000):ICardCashBack{
    SILVER("Silver"){
        override fun getCashBackrate()=0.02
    },
    GOLD("Gold",1000){
        override fun getCashBackrate()=0.03

    },
    PLATINUM("Platinum"){  //for these default value
        override fun getCashBackrate()=0.02

    }
}
fun main(){

    val card=CreditCardType.GOLD
    println(card.name)
    println(card.ordinal)
    val arr=CreditCardType.values()
    val car=CreditCardType.valueOf("silver".uppercase())
    println(car)
    when(card){
        CreditCardType.SILVER -> print("The card type is Silver")
        CreditCardType.GOLD ->  print("The card type is gold")
        CreditCardType.PLATINUM ->  print("The card type is Platinum")
    }
}
