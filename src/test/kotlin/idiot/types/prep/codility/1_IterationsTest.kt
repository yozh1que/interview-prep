package idiot.types.prep.codility

import org.junit.Test

import org.junit.Assert.*

class `1_IterationsTest` {

    @Test
    fun solution() {
        assertEquals(
            2,
            binaryGap(9)
        )
        assertEquals(
            1,
            binaryGap(5)
        )
        assertEquals(
            0,
            binaryGap(1)
        )
        assertEquals(
            4,
            binaryGap(529)
        )
        assertEquals(
            0,
            binaryGap(15)
        )
        assertEquals(
            0,
            binaryGap(32)
        )
        assertEquals(
            4,
            binaryGap(74901729)
        )
    }

    @Test
    fun testBinaryGap2() {
        assertEquals(
                2,
                binaryGap2(9)
        )
        assertEquals(
                1,
                binaryGap2(5)
        )
        assertEquals(
                0,
                binaryGap2(1)
        )
        assertEquals(
                4,
                binaryGap2(529)
        )
        assertEquals(
                5,
                binaryGap2(1041)
        )
        assertEquals(
                0,
                binaryGap2(32)
        )

    }
}