fun main(args: Array<String>) {
  
  // builder
    val foodOrder = FoodOrder.Builder()
        .bread("white")
        .meat("bacon")
        .condiments("olive oil")
        .build()
}
