package idiot.types.prep.codility

import kotlin.math.absoluteValue
import kotlin.math.ceil
import kotlin.math.min

fun frogJmp(x: Int, y: Int, d: Int): Int {
    return ceil(((y.toFloat()) - x) / d).toInt()
}

fun permMissingElem(A: IntArray): Int {
    A.sort()
    var i = 1
    while (i < A.size) {
        if (A[i] - A[i-1] > 1) {
            return A[i] - 1
        }
        i++
    }
    return -1
}

fun tapeEquilibrium(A: IntArray): Int {
    val sum = A.sum()

    var i = 1
    var acc = A[0]
    var minRes: Int = (sum - acc).absoluteValue
    while (i < A.size - 1) {
        minRes = min(minRes, ((sum - (acc + A[i])) - acc + A[i]).absoluteValue)
        acc += A[i]
        i++
    }
    return minRes
}