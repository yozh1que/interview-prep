package idiot.types.prep.leetcode.arrays

import org.junit.Test

class ArrayRotationKtTest {

    @Test
    fun testRotateArray2() {
        intArrayOf(1, 2, 3, 4, 5).rotateBy(1)
        intArrayOf(1, 2, 3, 4, 5).rotateBy(2)
        intArrayOf(1, 2, 3, 4, 5, 6).rotateBy(1)
        intArrayOf(1, 2, 3, 4, 5, 6).rotateBy(2)
        intArrayOf(1, 2, 3, 4, 5, 6).rotateBy(-1)
        intArrayOf(1, 2, 3, 4, 5, 6).rotateBy(-2)
    }

    @Test
    fun testRotate2() {

        intArrayOf(1,2,3).rotate2By(1)
        intArrayOf(1,2,3).rotate2By(2)
        intArrayOf(1, 2, 3, 4, 5, 6).rotate2By(2)
        intArrayOf(1, 2, 3, 4, 5, 6).rotate2By(-2)
    }

    private fun IntArray.rotateBy(k: Int) {
        rotateArray(this, k)
        forEach(::print)
        println()
    }

    private fun IntArray.rotate2By(k: Int) {
        rotateArray(this, k)
        forEach(::print)
        println()
    }

}