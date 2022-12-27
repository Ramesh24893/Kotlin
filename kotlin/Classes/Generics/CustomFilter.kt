package Classes.Generics

fun<T> List<T>.customFilter(filterFunction:(T)->Boolean):List<T>{
    val filteredList= mutableListOf<T>()
   // val filteredList1= mutableListOf<S>()
    for(item in this){
        if(filterFunction(item)){
            filteredList.add(item)
        }
    }
    return filteredList

}