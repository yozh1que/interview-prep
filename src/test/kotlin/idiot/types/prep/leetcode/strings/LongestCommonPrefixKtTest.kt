package idiot.types.prep.leetcode.strings

import org.junit.Test

import org.junit.Assert.*

class LongestCommonPrefixKtTest {

    @Test
    fun testLongestCommonPrefix() {
        assertEquals(
                "fl",
                longestCommonPrefix(arrayOf("flower", "flow", "flight"))
        )
//        assertEquals(
//                "",
//                longestCommonPrefix(arrayOf("dog", "racecar", "car"))
//        )
    }
}