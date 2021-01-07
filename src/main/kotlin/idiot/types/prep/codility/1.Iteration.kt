package idiot.types.prep.codility

import kotlin.math.max

//A binary gap within a positive integer N is any maximal sequence of consecutive zeros
// that is surrounded by ones at both ends in the binary representation of N.
//
//For example, number 9 has binary representation 1001 and contains a binary gap of length 2.
//The number 529 has binary representation 1000010001 and contains two binary gaps: one of length 4 and one of length 3.
//The number 20 has binary representation 10100 and contains one binary gap of length 1.
//The number 15 has binary representation 1111 and has no binary gaps.
//The number 32 has binary representation 100000 and has no binary gaps.
//
//Write a function:
//
//class Solution { public int solution(int N); }
//
//that, given a positive integer N, returns the length of its longest binary gap. The function should return 0 if N doesn't contain a binary gap.
//
//For example, given N = 1041 the function should return 5, because N has binary representation 10000010001 and so its longest binary gap is of length 5. Given N = 32 the function should return 0, because N has binary representation '100000' and thus no binary gaps.
//
//Write an efficient algorithm for the following assumptions:
//
//N is an integer within the range [1..2,147,483,647].

// O(N)
fun binaryGap(n: Int): Int {
    var i = n
    val sb = StringBuilder()
    while (i > 0) {
        sb.append(i % 2)
        i /= 2
    }

    var max = 0
    var newMax = 0
    var startedGap = false
    var hasGap = false
    for (c in sb.reverse().apply(::println)) {
        if (c == '0') {
            startedGap = true
            newMax++
        } else if(startedGap) {
            hasGap = true
            startedGap = false
            max = newMax.takeIf { it > max } ?: max
            newMax = 0
        }
    }
    return max.takeIf { hasGap } ?: 0
}


// slightly more efficient than binaryGap
fun binaryGap2(n: Int): Int {
    var i = n

    var maxGap = 0
    var currentGap: Int? = null

    while(i > 0) {
        if (i % 2 == 1) {
            if(currentGap != null) {
                maxGap = max(maxGap, currentGap)
            }
            currentGap = 0
        } else {
            if (currentGap != null) {
                currentGap++
            }
        }
        i /= 2
    }
    return maxGap
}