package idiot.types.prep.codility

import kotlin.math.absoluteValue

data class Point(
    val absProduct: Int,
    val tag: Char
)
fun task1(S: String, X: IntArray, Y: IntArray): Int {

    assert(S.isNotEmpty())
    assert(S.length == X.size && X.size == Y.size)

    val duplicates = mutableSetOf<Char>()

    val points = (S.indices).map { Point(
        (X[it] * Y[it]).absoluteValue,
        S[it]
    ) }.sortedBy {
        it.absProduct
    }

    var i = 0
    var j: Int
    while (i < points.size) {
        if (!duplicates.contains(points[i].tag)) {
            j = i + 1
            var f = false
            while (j <= points.size && points[j].absProduct == points[i].absProduct) {
                if (points[j].tag == points[i].tag) {
                    f = true
                    break
                }
            }
            if (!f) {
                duplicates.add(points[i].tag)
            } else {
                break
            }
        } else {
            break
        }
        i++
    }

    return i
}

fun task2(S: String, K: Int): Int {

    val candidates = mutableMapOf<String, Int>()

    var i = 1
    var seq = 1
    var segmentStart = 0
    var lastChar = S[0]
    while (i < S.length) {
        if (S[i] != lastChar) {
            if (i + K >= S.length || S[i + K] != lastChar) {
                candidates["${lastChar}_$segmentStart"] = seq
            } else {
                var j = i + K
                while (j < S.length) {
                    if (S[j] != lastChar) {
                        break
                    }
                    j++
                }
                candidates["${lastChar}_$i"] = seq + (j - (i + K))
            }
            seq = 1
            segmentStart = i
            lastChar = S[i]
        } else {
            seq++
        }


        i++
    }

    candidates.entries.forEach(::println)

    val maxCompressionStart = candidates.maxBy { it.value }!!.key.split("_")[1].toInt()

    println("maxCompressionStart: $maxCompressionStart")

    S.substring(0, maxCompressionStart) + S.substring(maxCompressionStart + K, S.length)

    val cutString  = S.substring(0, maxCompressionStart) + S.substring(maxCompressionStart + K, S.length)
    println(cutString)

    i = 1
    seq = 1
    lastChar = cutString[0]
    val compressed = mutableListOf<String>()
    while (i < cutString.length) {

        if (lastChar != cutString[i]) {
            if (seq == 1) {
                compressed.add("$lastChar")
            } else {
                compressed.add("$seq$lastChar")
            }

            lastChar = cutString[i]
           seq = 1
        } else {
            seq++
        }
        i++

    }

    compressed.add("$seq$lastChar")

    return compressed.joinToString("").apply {
        println(this)
    }.length

}


















