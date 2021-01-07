package idiot.types.prep.leetcode.arrays

import org.junit.Test

import org.junit.Assert.*

class MaxProfitKtTest {

    @Test
    fun testMaxProfit() {
        assertEquals(4, maxProfit(intArrayOf(1,2,3,4,5)))
        assertEquals(7, maxProfit(intArrayOf(7,1,5,3,6)))
    }
}