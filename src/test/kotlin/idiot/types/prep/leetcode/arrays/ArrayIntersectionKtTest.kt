package idiot.types.prep.leetcode.arrays

import org.junit.Test
import javax.print.attribute.IntegerSyntax
import kotlin.test.assertTrue

internal class ArrayIntersectionKtTest {

    @Test
    fun testIntersect() {
        assertTrue(intArrayOf(1, 2).contentEquals(intersect(intArrayOf(1, 2, 3), intArrayOf(1, 2))))
        assertTrue(intArrayOf(1).contentEquals(intersect(intArrayOf(1, 4, 3), intArrayOf(1, 2, 1))))
        assertTrue(intArrayOf().contentEquals(intersect(intArrayOf(6, 4, 3), intArrayOf(1, 2, 1))))
    }

    @Test
    fun testIntersect2() {
//        assertTrue(intArrayOf(1, 2).contentEquals(intersect2(intArrayOf(1, 2, 3), intArrayOf(1, 2))))
        assertTrue(intArrayOf(1).contentEquals(intersect2(intArrayOf(1, 4, 3), intArrayOf(1, 2, 1))))
        assertTrue(intArrayOf(1,5).contentEquals(intersect2(intArrayOf(1, 1, 4, 5), intArrayOf(1, 2, 3, 5))))
        assertTrue(intArrayOf(1,5).contentEquals(intersect2(intArrayOf(1, 1, 4, 5, 7, 9, 10), intArrayOf(1, 2, 3, 5))))
//        assertTrue(intArrayOf().contentEquals(intersect2(intArrayOf(6, 4, 3), intArrayOf(1, 2, 1))))
    }
}