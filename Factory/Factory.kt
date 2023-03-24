/*
Factory is fixed. Only 1 implementation with no subclassing
 */

interface Part
class Engine: Part
class Chassis: Part


class PartsFactory {
    fun makeEngine(): Engine { return Engine() }
    fun makeChassis(): Chassis { return Chassis() }
}
