package practise

class Anonymous {

}

fun main(){
    val ani=object : Tiger(){   //no need to create new named class
         val age1: Int=1
           // get() = 29
        override fun eat():String{
            return "Tiger is eating"
        }
    }
    val ani1=Tiger()


}

