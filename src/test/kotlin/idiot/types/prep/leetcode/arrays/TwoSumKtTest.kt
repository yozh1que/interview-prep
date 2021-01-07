package idiot.types.prep.leetcode.arrays

import org.junit.Test

import org.junit.Assert.*

class TwoSumKtTest {

    @Test
    fun testTwoSum() {
        twoSum(intArrayOf(2,7,11,15), 9).apply {
            forEach { print("$it, ") }
        }
    }
}