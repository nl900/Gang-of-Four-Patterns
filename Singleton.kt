/*
Useed when dealing with multithreaded applications where a reliable single source of truth is required.

In Kotlin, the implementation is thread-safe out of the box.
 */

object PrinterDriver {
    // init block executes immediately after the primary constructor
    // it becomes part of the primary constructor
    init {
        println("Initializing with object: $this")
    }

    fun print(): PrinterDriver =
        apply { println("Printing with object: $this") }
}

fun main(args: Array<String>) {
    val printer1 = PrinterDriver.print()
    val printer2 = PrinterDriver.print()
}
