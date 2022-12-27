package reference

open class A {
    open fun foo(i: Int = 165) {
    println(i)/*...*/ }
}
open class B : A() {
    override fun foo(i: Int) {
    println(i)/*...*/ } // No default value is allowed.
}class  C: B() {
    override fun foo(i: Int) {
        println(i)/*...*/ } // No default value is allowed.
}

fun main(args: Array<String>){
    val a=A()
    a.foo()
    val b=B()
    b.foo()
    val c=C()
    c.foo()
}