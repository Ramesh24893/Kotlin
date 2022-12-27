package Classes.Interface

interface A {
    var name:String
        get(){
            return "heelo"
        }
        set(value){

        }
    fun foo() { print("A") }
    fun bar()
}

interface B {
    fun foo() { print("B") }
    fun bar() { print("bar") }
}

class C : A {
    override fun bar() { print("bar") }
    override var name: String="h"
//        get() = super.name
//        set(value) {}
}

class D : A, B {
    override fun foo() {
//        super<A>.foo()
//        super<B>.foo()
    }

    override fun bar() {
       // super<B>.bar()
    }
}