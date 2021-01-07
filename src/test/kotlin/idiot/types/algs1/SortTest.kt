package idiot.types.algs1

import org.junit.Test
import kotlin.test.assertTrue

class SortTest {
    @Test
    fun `test selection sort`() {
        assertTrue(
            arrayOf(1, 2, 3, 4, 5).contentEquals(selectionSort(arrayOf(4, 5, 3, 2, 1) as Array<Comparable<Int>>))
        )
    }
}