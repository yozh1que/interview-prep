package idiot.types.prep.book

import kotlin.math.max
import kotlin.math.min

// Example: Given an array of distinct integer values, count the number of pairs of integers that
// have difference k. For example, given the array {1, 7, 5, 9, 2, 12, 3} and the difference
// k = 2, there are four pairs with difference 2: (1, 3), (3, 5), (5, 7), (7, 9) .

data class IntPair(
    val first: Int,
    val second: Int
)

// O(N*logN + N*2LogN)
fun diffPairsSorted(arr: IntArray, k: Int): Set<IntPair> {
    // сортируем, чтобы быстрее искать бинарным поиском
    arr.sort()
    val pairs = mutableSetOf<IntPair>()
    var i = 0
    println()
    while (i < arr.size) {
        arr.binarySearch(arr[i] - k).takeIf { it > 0 }?.let {
            pairs.add(IntPair(max(arr[it], arr[i]), min(arr[it], arr[i])))
        }
        arr.binarySearch(arr[i] + k).takeIf { it > 0 }?.let {
            pairs.add(IntPair(max(arr[it], arr[i]), min(arr[it], arr[i])))
        }
        i++
    }
    return pairs
}

// O(N)
fun diffPairsMapped(arr: IntArray, k: Int): Set<IntPair> {
    val pairs = mutableSetOf<IntPair>()
    val map = arr.map { it to it }.toMap()
    map.keys.map {
        if (map.containsKey(map[it]!! - k)) {
            pairs.add(IntPair(max(map[it - k]!!, map[it]!!), min(map[it - k]!!, map[it]!!)))
        }
        if (map.containsKey(map[it]!! + k)) {
            pairs.add(IntPair(max(map[it + k]!!, map[it]!!), min(map[it + k]!!, map[it]!!)))
        }

    }
    return pairs
}