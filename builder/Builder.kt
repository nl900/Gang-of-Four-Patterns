class FoodOrder private constructor(
    val bread: String?,
    val condiments: String?,
    val meat: String?,
    val fish: String?) {

    // hold data without boiler plate code
    data class Builder(
        var bread: String? = null,
        var condiments: String? = null,
        var meat: String? = null,
        var fish: String? = null) {

        fun bread(bread: String) = apply { this.bread = bread }
        fun condiments(condiments: String) = apply { this.condiments = condiments }
        fun meat(meat: String) = apply { this.meat = meat }
        fun fish(fish: String) = apply { this.fish = fish }
        fun build() = FoodOrder(bread, condiments, meat, fish)
    }
}

fun main(args: Array<String>) {
  
    val foodOrder = FoodOrder.Builder()
        .bread("white")
        .meat("bacon")
        .condiments("olive oil")
        .build()
}
