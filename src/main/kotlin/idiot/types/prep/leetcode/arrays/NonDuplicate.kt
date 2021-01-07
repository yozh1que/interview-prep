package idiot.types.prep.leetcode.arrays

fun findNonDuplicate(intArray: IntArray): Int {
    return intArray.reduce { acc, next -> acc xor next}
}