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

    val sequence = generateSequence(1) { (1..100).random() }

    val result2 = sequence.take(1000).filterByFrequency(n).take(10).toList()
    println(result2)
}

fun <T> Sequence<T>.filterByFrequency(n: Int): Sequence<T> {

    val elementToCount = mutableMapOf<T, Int>().withDefault { 0 }
    val uniqueElements = mutableSetOf<T>()

    return this.filter { element ->
        val count = elementToCount.getValue(element)
        elementToCount[element] = count + 1
        count + 1 <= n && uniqueElements.add(element)
    }
}

fun <T> filterElementsByFrequency(list: List<T>, n: Int): List<T> {

    tailrec fun filterRecursively(inputList: List<T>, result: List<T> = emptyList()): List<T> {
        if (inputList.isEmpty()) {
            return result
        }

        val head = inputList.first()
        val count = inputList.count { it == head }

        val remainingList = inputList.filter { it != head }
        val updatedResult = if (count > n) result + head else result

        return filterRecursively(remainingList, updatedResult)
    }

    return filterRecursively(list)
}
