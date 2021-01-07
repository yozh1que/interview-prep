package idiot.types.prep.leetcode.arrays

import kotlin.math.max

// O(max(N,M)) time, O(max(N,M)) space
fun addBinary(a: String, b: String): String {
    val resultSb = StringBuilder(a.length + b.length)

    var i = a.length - 1
    var j = b.length - 1
    var maxLen = max(a.length, b.length)
    var hasCarry = false

    while (maxLen > 0) {
        if (a.charOrZero(i) == '1' && b.charOrZero(j) == '1') {
            resultSb.insert(0, '1'.takeIf { hasCarry } ?: '0')
            hasCarry = true
        } else if (a.charOrZero(i) == '1' || b.charOrZero(j) == '1') {
            if (hasCarry) {
                resultSb.insert(0, '0')
            } else {
                resultSb.insert(0, '1')
            }
        } else {
            resultSb.insert(0, '1'.takeIf { hasCarry } ?: '0')
            hasCarry = false
        }
        i--
        j--
        maxLen--
    }
    if (hasCarry) {
        resultSb.insert(0, '1')
    }
    return resultSb.toString()
}

fun String.charOrZero(index: Int) = if (index >= 0) {
    get(index)
} else {
    '0'
}