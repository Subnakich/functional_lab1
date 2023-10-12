fun main(args: Array<String>) {
//    println("Hello World!")
//
//    // Try adding program arguments via Run/Debug configuration.
//    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
//    println("Program arguments: ${args.joinToString()}")

    val list = listOf(1, 2, 2, 3, 4, 4, 4, 5, 5, 6)
    val n = 2
    val result = filterElementsByFrequency(list, n)
    println("Элементы, встречающиеся более $n раз: $result")
}

fun <T> filterElementsByFrequency(list: List<T>, n: Int): List<T> {
    // Создаем мапу для подсчета частоты встречаемости элементов
    val elementCountMap = list.groupingBy { it }.eachCount()

    // Фильтруем элементы списка, оставляя только те, которые встречаются более n раз
    return list.filter { (elementCountMap[it] ?: 0) > n }
}