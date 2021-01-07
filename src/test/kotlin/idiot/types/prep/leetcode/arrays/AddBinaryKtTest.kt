package idiot.types.prep.leetcode.arrays

import org.junit.Test

import org.junit.Assert.*

class AddBinaryKtTest {

    @Test
    fun testAddBinary() {
        assertEquals("111", addBinary("101", "10"))
        assertEquals(7, addBinary("101", "10").toInt(radix = 2))
        assertEquals("10101", addBinary(a = "1010", b = "1011"))
        assertEquals(21, addBinary(a = "1010", b = "1011").toInt(radix = 2))

        println(addBinary(a = "1111", b = "1111").toInt(radix = 2))


    }
}