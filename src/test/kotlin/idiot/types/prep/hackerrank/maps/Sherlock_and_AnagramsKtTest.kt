package idiot.types.prep.hackerrank.maps

import org.junit.Test

import org.junit.Assert.*

class SherlockAndAnagramsKtTest {

    @Test
    fun testAnagrams() {
        anagrams("mom").forEach(::println)
        println("------------------------------------------------------")
        anagrams("abba").forEach(::println)
        println("------------------------------------------------------")
        anagrams("ifailuhkqq").forEach(::println)
    }
}