package idiot.types.prep.leetcode.arrays

import kotlin.math.abs

// O(n) time, O(1) space
fun rotateArray(arr: IntArray, move: Int) {

    var k: Int = when {
        move < 0 -> arr.size - abs(move)
        move > 0 -> move
        else -> return
    }

    var i = 0
    var loopOffset = 0
    var innerIncrement: Int
    var prev: Int
    while (i < arr.size) {
        innerIncrement = 0

        prev = arr[loopOffset]
        do {
            var nextIndex = ((innerIncrement + 1) * k + loopOffset) % arr.size
            var nextHolder = arr[nextIndex]
            arr[nextIndex] = prev
            prev = nextHolder
            innerIncrement++
            i++
        } while (((innerIncrement * k + loopOffset) % arr.size)  != loopOffset && i < arr.size)

        loopOffset++
    }
}

// O(2?n) time, O(n) space
fun rotateArray2(arr: IntArray, move: Int) {
    var k: Int = when {
        move < 0 -> arr.size - abs(move)
        move > 0 -> move
        else -> return
    }

    var arr2 = IntArray(arr.size)

    var i = 0
    while (i < arr.size) {
        arr2[(i+k)% arr.size] = arr[i]
        i++
    }
    i = 0
    while (i< arr.size) {
        arr[i] = arr2[i]
        i++
    }
}