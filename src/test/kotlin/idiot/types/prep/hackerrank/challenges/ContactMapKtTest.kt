package idiot.types.prep.hackerrank.challenges

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ContactMapKtTest {
    @Test
    fun testTrie() {
        val t = Trie()
        t.put("ab")
        t.put("abc")
        t.put("abcd")
        t.put("aqe")

        assertEquals(
            3,
            t.getWordCountForPrefix("ab")
        )
        assertEquals(
            0,
            t.getWordCountForPrefix("ac")
        )
        assertEquals(
            0,
            t.getWordCountForPrefix("ac")
        )
        assertEquals(
            4,
            t.getWordCountForPrefix("a")
        )
    }

    @Test
    fun testContacts() {
        assertTrue(
            contacts(arrayOf(
                arrayOf("add", "hack"),
                arrayOf("add", "hackerrank"),
                arrayOf("find", "hac"),
                arrayOf("find", "hak"),
            )).contentEquals(arrayOf(2, 0))
        )
    }
}