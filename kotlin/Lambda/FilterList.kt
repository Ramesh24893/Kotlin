package Lambda

fun main(){
    var list=(1..20).toList()
    list=list.filter{irt->
        irt%2==0}
}