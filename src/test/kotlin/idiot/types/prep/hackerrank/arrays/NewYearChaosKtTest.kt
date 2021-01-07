package idiot.types.prep.hackerrank.arrays

import org.junit.Test

import org.junit.Assert.*

// 2 1 5 3 4
// 2 1 3 5 4, "5" bribed "3"

// 1 2 3 4 5, "5" bribed "4"
// 1 2 3 4 5, // "2" bribed "1"
// hence, 3 bribes

class NewYearChaosKtTest {

    @Test
    fun testMinimumBribes() {
// 2 1 5 3 4
// 1 2 5 3 4, "2" bribed "1"
// 1 2 3 5 4, "5" bribed "3"
// 1 2 3 4 5, "5" bribed "4"
// hence, 3 bribes
        assertEquals(
            3,
            minimumBribes(arrayOf(2, 1, 5, 3, 4))
        )

// 2 5 1 3 4
// 2 1 5 3 4
// 2 1 3 5 4
// 2 1 3 4 5
// hence, "5" bribed 3 times

        assertEquals(
            -1,
            minimumBribes(arrayOf(2, 5, 1, 3, 4))
        )

// 5 1 2 3 7 8 6 4
// 5 1 2 3 7 8 4 6, 6 -> 4
// 5 1 2 3 7 4 8 6, 8 -> 4
// 5 1 2 3 4 7 8 6, 7 -> 4


        assertEquals(
            -1,
            minimumBribes(arrayOf(5, 1, 2, 3, 7, 8, 6, 4))
        )

    }
}