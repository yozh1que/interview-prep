package idiot.types.algs1

import org.junit.Test

import org.junit.Assert.*

class DynamicConnectivityTest {

    @Test
    fun `test spread`() {
        QuickUnionWeighted(10).apply {
            assertEquals(10, count())
            objects.forEach {
                print("$it ")
            }
            assertFalse(connected(0,1))
            union(0, 1)
            objects.forEach {
                print("$it ")
            }
            union(1, 2)
            objects.forEach {
                print("$it ")
            }

        }
    }

}