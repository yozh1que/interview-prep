package idiot.types.prep.codility

import org.junit.Test

import org.junit.Assert.*

class ArraysTest {

    @Test
    fun testCyclicRotation() {
        println(cyclicRotation(intArrayOf(1,2,3,4,5), 1).joinToString(", "))
        println(cyclicRotation(intArrayOf(1,2,3,4,5), 2).joinToString(", "))
        println(cyclicRotation(intArrayOf(1,2,3,4,5), 3).joinToString(", "))
    }

    @Test
    fun testGcd() {
        println(gcd(4,9))
    }

    @Test
    fun testOddOccurrences() {
        println(oddOccurrencesInArray(intArrayOf(1,2,1,2,3)))
        println(oddOccurrencesInArray(intArrayOf(1,2,3,1,2)))
    }
}