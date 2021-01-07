package idiot.types.prep.leetcode.arrays

import org.junit.Test

import org.junit.Assert.*

class RemoveDuplicatesKtTest {

    @Test
    fun testRemoveDuplicates() {
        val arr = intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)
        assertEquals(5, removeDuplicates(arr))
        assertTrue(intArrayOf(0, 1, 2, 3, 4).contentEquals(arr.copyOfRange(0, 5)))
    }
}