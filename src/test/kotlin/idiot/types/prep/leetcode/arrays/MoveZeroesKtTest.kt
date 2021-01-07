package idiot.types.prep.leetcode.arrays

import org.junit.Test

import org.junit.Assert.*

class MoveZeroesKtTest {

    @Test
    fun testMoveZeroes() {
        intArrayOf(0,1,0,3,12).apply {
            moveZeroes(this)
            assertTrue(
                    this.contentEquals(intArrayOf(1,3,12,0,0))
            )
        }

        intArrayOf(0,2,0,1,0,3,12).apply {
            moveZeroes(this)
            assertTrue(
                    this.contentEquals(intArrayOf(2, 1,3,12,0,0,0))
            )
        }
    }
}