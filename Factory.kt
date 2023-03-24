interface CarParts
class Engine: CarParts
class Chassis: CarParts

/*
Factory is fixed. Only 1 implementation with no subclassing
 */
class PartsFactory {
    fun makeEngine(): Engine { return Engine() }
    fun makeChassis(): Chassis { return Chassis() }
}

/*
Abstract factory is used for dependency inection / strategy, to create a whole family of objects that need to be of the same kind
and have common base classes
An interface that allows a family of closely related classes to be instantiated
The example below, the interface acts as a blueprint for what kind of car parts the independent factories should build and
from what arguments. The factories / subclasses will then build the parts based on the requirements and processes specific
 */
abstract class CarPartsFactory {
    abstract fun buildEngine(): Engine
    abstract fun buildChassis(): Chassis

}

class CarPartsFactoryProvider {
    // reified keyword allows the function to access the generic type M as a normal class in the function body at runTime
    // otherwise it's only available at compile time and erased at runtime
    inline fun <reified M : CarPartsFactory> createFactory(): CarPartsFactory {
        return when (M::class) {
            AudiPartsFactory::class -> AudiPartsFactory()
            ToyotaPartsFactory::class -> ToyotaPartsFactory()
            else -> throw IllegalArgumentException()
        }
    }
}

class AudiPartsFactory: CarPartsFactory() {
    override fun buildEngine(): Engine { return Engine() }
    override fun buildChassis(): Chassis { return Chassis() }
}

class ToyotaPartsFactory: CarPartsFactory() {
    override fun buildEngine(): Engine { return Engine() }
    override fun buildChassis(): Chassis { return Chassis() }
}

fun main(args: Array<String>) {
    val factoryProvider = CarPartsFactoryProvider()
    val partsFactory = factoryProvider.createFactory<AudiPartsFactory>()
    val engine = partsFactory.buildEngine()
    println("created engine: $engine")
}
