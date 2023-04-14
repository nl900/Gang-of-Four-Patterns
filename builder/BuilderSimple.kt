data class Person(var name: String, var age: Int)

/*
apply is a scope/extension function takes a lambda expression which modify the properties of the receiver object of type T and returns the object reference
Below the apply function modify the Person object to add to the age property and returns the modified Person object
*/

fun main(args: Array<String>) {
  val p = Person("John", 20).apply {
    age += 1
  }
}
