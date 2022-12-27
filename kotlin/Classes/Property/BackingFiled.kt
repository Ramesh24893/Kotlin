package Classes

class Pulsar(mileage:Int){
    private var mileage:Int=mileage
        get(){
            return if(field>40)
                field
            else
                0
    }
        set(value){
            if(true)
        field=value
    }
    fun printMileage(){
        println(mileage)
    }
}