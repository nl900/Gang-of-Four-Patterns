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
