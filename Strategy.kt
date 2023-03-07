class Printer(private val stringFormatStrategy: (String) -> String) {
    fun printString(string: String) {
        println(stringFormatStrategy(string))
    }
}

val lowerCaseFormatter: (String) -> String = { it.toLowerCase() }
val upperCaseFormatter: (String) -> String = { it.toUpperCase() }

fun main(args: Array<String>) {
    val inputstr = "DU sldkf"

    val lowerCasePrinter = Printer(lowerCaseFormatter)
    lowerCasePrinter.printString(inputstr)

    val upperCasePrinter = Printer(upperCaseFormatter)
    upperCasePrinter.printString(inputstr)

    val prefixPrinter = Printer { "Prefix: $it"}
    prefixPrinter.printString(inputstr)
}
