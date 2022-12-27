package Classes.Generics

class CustomTriple<P:Any,Q:Any,R:Any>(
    private val first: P,
    private val second:Q,
    private val third:R
) {
    fun printTypes() {
        print("The type is ${first::class}")
        print("The type is ${second::class}")
        print("The type is ${third::class}")
    }
}