package idiot.types.prep.leetcode.arrays

import kotlin.math.min

// O(n + m) time, O(min(n,m)) space
fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
    val iterArray = nums1.takeIf { it.size < nums2.size } ?: nums2
    val iterMap = mutableMapOf<Int,Int>()

    iterArray.forEach { iterMap[it] = iterMap.getOrDefault(it, 0) + 1 }

    val compareArray = nums1.takeIf { it.size >= nums2.size } ?: nums2
    val result = IntArray(compareArray.size)
    var c = 0
    compareArray.forEach {
        if (iterMap.containsKey(it) && iterMap.getOrDefault(it, -1) > 0) {
            result[c++] = it
            iterMap[it] = iterMap.getOrDefault(it, 0) - 1
        }
    }

    return result.sliceArray(0 until c).also {
        it.forEach { print("$it, ")  }
        println()
    }
}

fun intersect2(nums1: IntArray, nums2: IntArray): IntArray {
    nums1.sort()
    nums2.sort()

    var i = 0
    var j = 0
    val intersections = ArrayList<Int>(min(nums1.size, nums2.size))
    while (i < nums1.size && j < nums2.size) {
        if (nums1[i] == nums2[j]) {
            intersections.add(nums1[i])
            i++
            j++
        } else if (nums1[i] < nums2[j]) {
            i++
        } else {
            j++
        }
    }
    return intersections.toIntArray().also {
        it.forEach { print("$it, ")  }
        println()
    }
}