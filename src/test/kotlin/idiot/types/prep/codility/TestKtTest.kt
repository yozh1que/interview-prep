package idiot.types.prep.codility

import org.junit.Test

import org.junit.Assert.*

class TestKtTest {

    @Test
    fun testTask1() {
        assertEquals(
            3,
            task1("ABDCA", intArrayOf(2, -1, -4, -3, 3), intArrayOf(2, -2, 4, 1, -3))
        )
        assertEquals(
            1,
            task1("ABB", intArrayOf(1, -2, -2), intArrayOf(1, -2, 2))
        )
        assertEquals(
            0,
            task1("CCD", intArrayOf(1, -1, 2), intArrayOf(1, -1, -2))
        )
    }

    @Test
    fun testTask2() {
        assertEquals(
            5,
            task2("ABBBCCDDCCC", 3)
        )
        assertEquals(
            2,
            task2("AAABCDAAA", 3)
        )
    }
}