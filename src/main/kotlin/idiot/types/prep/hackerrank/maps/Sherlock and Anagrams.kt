package idiot.types.prep.hackerrank.maps


// mom: m-m, mo-om
// abba: a-a, b-b, ab-ba, abb-bba
fun anagrams(s: String): List<Pair<String, String>> {



    return s.groupBy { it }
        .map { it.key to it.value.size }
        .let { charToOccurrence -> charToOccurrence
            .filter { it.second >= 2 }
            .map { pair -> listOfNotNull(
                listOf("${pair.first}" to "${pair.first}"),
                charToOccurrence.filter { it.first != pair.first }
                    .map { "${pair.first}${it.first}" to "${it.first}${pair.first}" }
                    .takeIf { it.isNotEmpty() }
            ).flatten() }
            .flatten()

//            it.filter { it.second % 2 == 0 }.map { it.first }
        }


}