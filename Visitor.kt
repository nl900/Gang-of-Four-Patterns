/*
Separates an algorithm from the object allowing to add new operations to the object without modifying the strucutre.

Sealed class allow fix type hierarchies. They're useful in strict inheritance hierarchy where a specific set of subclasses
are possible and each of the options are functionally different.
*/

sealed class Shape()
class Square(val side: Double) : Shape()
class Circle(val radius: Double) : Shape()
class Rectangle(val width: Double, val height: Double) : Shape()

fun main(args: Array<String>) {

    val perimeterVisitor = { shape: Shape ->
        when (shape) {
            is Rectangle -> 2 * shape.height + 2 * shape.width
            is Circle -> 2 * Math.PI * shape.radius
            is Square -> 4 * shape.side
        }
    }

    val areaVisitor = { shape: Shape ->
        when (shape) {
            is Rectangle -> shape.height * shape.width
            is Circle -> shape.radius * shape.radius * Math.PI
            is Square -> shape.side * shape.side
        }
    }

    val figures = listOf(Circle(4.0), Square(5.0), Rectangle(6.0, 7.0))
    figures.forEach{
        perimeterVisitor(it)
    }

    figures.forEach{
        areaVisitor(it)
    }
}
