package idiot.types.prep.book

import com.sun.scenario.effect.impl.prism.PrRenderInfo

// Implement an algorithm to determine if a string has all unique characters.
// What if you cannot use additional data structures?

// O(N*logN)
fun hasOnlyUniqueSymbols(s: String): Boolean {
    val sortedString = s.toCharArray().sorted()
    var i = 1;
    while (i < sortedString.size - 1) {
        if (sortedString[i - 1] == sortedString[i] || sortedString[i + 1] == sortedString[i]) {
            return false
        }
        i++
    }
    return true
}

// Check Permutation: Given two strings, write a method to decide if one is a permutation
// of the other
fun checkPermutation(test: String, ofString: String): Boolean {
    val testMap = mutableMapOf<Char, Int>()
    val testLen = test.length
    test.toCharArray().forEach { testMap[it] = testMap.getOrDefault(it, 0) + 1 }

    var charsLeftToInspect = testLen
    var foundSimilarSymbols = false
    ofString.forEach {
        if (
            !foundSimilarSymbols && testMap.containsKey(it) ||
            (foundSimilarSymbols && testMap.containsKey(it) && testMap[it]!! - 1 >= 0)
        ) {
            foundSimilarSymbols = true
            charsLeftToInspect--
            testMap[it] = testMap[it]!! - 1

            if (charsLeftToInspect == 0) {
                return true
            }
        } else {
            charsLeftToInspect = testLen
        }
    }
    return false
}

// Write a method to replace all spaces in a string with '%20: You may assume that the string
// has sufficient space at the end to hold the additional characters, and that you are given the "true"
// length of the string. (Note: If implementing in Java, please use a character array so that you can
// perform this operation in place.)
fun urlify(s: CharArray): String {
    val spaceUrlifiedReversed = "%20".reversed()
    var i = s.size - 1
    var moveIndex = -1
    var foundChar = false
    while (i >= 0) {
        if (moveIndex == -1 && !foundChar && s[i] == ' ') {
            moveIndex = i
        }
        if (s[i] != ' ') {
            foundChar = true
            s[moveIndex--] = s[i]

        }
        if (s[i] == ' ' && foundChar) {
            spaceUrlifiedReversed.forEach {
                s[moveIndex--] = it
            }
        }

        i--
    }

    return s.joinToString("")
}

// One Away: There are three types of edits that can be performed on strings: insert a character,
// remove a character, or replace a character. Given two strings, write a function to check if they are
// one edit (or zero edits) away.

// EXAMPLE
// pale, ple -> true
// pales, pale -> true
// pale, bale -> true
// pale, bake -> false

fun oneWay(base: String, test: String): Boolean {
    var i = 0
    while (i < test.length) {
        if (test[i] != base[i]) {

            var j = test.length - 1
            var k = base.length - 1
            var downTo = when {
                test.length < base.length -> i - 1
                else -> i
            }
            while (j > downTo) {
                println("${base[k]} ${test[j]}")

                if (base[k] != test[j]) {
                    return false
                }
                j--
                k--
            }

            break
        }
        i++
    }

    return true
}

class LinkedList<T> {
    class Node<T>(
        val data: T,
        var next: Node<T>? = null
    )

    var head: Node<T>? = null

    fun append(data: T) {
        if (head == null) {
            head = Node(data)
        } else {
            var i = head
            while (i?.next != null) {
                i = i.next
            }
            i?.next = Node(data)
        }
    }

    fun delete(data: T) {
        if (head == null) {
            return
        }
        var i = head
        while (i?.next != null) {
            if (i?.next?.data == data) {
                i.next = i?.next?.next
                return
            }
            i = i.next
        }
    }
}

class Stack<T> {
    class Node<T>(
        val data: T,
        var next: Node<T>? = null
    )

    var top: Node<T>? = null

    fun push(data: T) {
        if (top == null) {
            top = Node(data)
        } else {
            top = Node(data).apply {
                next = top
            }
        }
    }

    fun pop(): T? {
        return if(top == null) {
            null
        } else {
            top?.apply {
                top = next
            }!!.data

        }
    }

}

class Queue<T> {
    class Node<T>(
        val data: T,
        var next: Node<T>? = null
    )

    var head: Node<T>? = null
    var tail: Node<T>? = null

    fun add(data: T) {
        if(head == null) {
            head = Node(data)
            tail = head
        } else {
            val n = Node(data)

            tail?.next = n
            tail = n
        }
    }

    fun remove():T? {
        return if (head == null) {
            null
        } else {
            head?.apply {
                head = next
            }?.data
        }
    }

}