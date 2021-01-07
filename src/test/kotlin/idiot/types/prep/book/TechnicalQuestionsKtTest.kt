package idiot.types.prep.book

import org.junit.Test

class TechnicalQuestionsKtTest {

    @Test
    fun testDiffPairs() {
//        diffPairsSorted(intArrayOf(1, 7, 5, 9, 2, 12, 3), 2).forEach {
//            println("${it.first} ${it.second}")
//        }

        diffPairsMapped(intArrayOf(1, 7, 5, 9, 2, 12, 3), 2).forEach {
            println("${it.first} ${it.second}")
        }
    }
}