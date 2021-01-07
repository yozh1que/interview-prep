package idiot.types.prep.book

import org.junit.Test

import org.junit.Assert.*

class DataStructuresKtTest {

    @Test
    fun testHasOnlyUniqueSymbols() {
        assertTrue(
            hasOnlyUniqueSymbols("abc")
        )
        assertFalse(
            hasOnlyUniqueSymbols("abb")
        )
    }

    @Test
    fun testCheckPermutation() {
        assertTrue(
            checkPermutation("abc", "cba")
        )
        assertFalse(
            checkPermutation("abcc", "cba")
        )
    }

    @Test
    fun testUrlify() {
        assertEquals(
            "Mr%20John%20Smith",
            urlify("Mr John Smith    ".toCharArray())
        )
    }

    @Test
    fun testOneWay() {
        assertTrue(oneWay("pale", "ple"))
        assertTrue(oneWay("pales", "pale"))
        assertTrue(oneWay("pale", "bale"))
        assertFalse(oneWay("pale", "bake"))
    }

    @Test
    fun testLinkedList() {
        val l = LinkedList<Int>()
        l.append(1)
        l.append(2)
        l.append(3)
        var i = l.head
        while (i != null) {
            println(i.data)
            i = i.next
        }

        l.delete(2)

        i = l.head
        while (i != null) {
            println(i.data)
            i = i.next
        }
    }

    @Test
    fun testStack() {
        val s = Stack<Int>()
        s.push(1)
        s.push(2)

        println(s.pop())
        println(s.pop())
        println(s.pop())
    }

    @Test
    fun testQueue() {
        val q = Queue<Int>()
        q.add(1)
        q.add(2)
        println(q.remove())
        println(q.remove())
        println(q.remove())
    }

}