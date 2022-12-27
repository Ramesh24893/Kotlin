package Classes

class NestedClass {
}
class Outer {
    private val bar: Int = 1
    inner class Inner {
        fun foo() = bar
        inner class deeper{
            inner class moreDeeper{

            }

        }
    }
}