package idiot.types.prep.leetcode.strings

//fun longestCommonPrefix(strs: Array<String>): String {
//    var i = 1
//    var prefix = strs[0]
//    while (i < strs.size) {
//        while (strs[i].indexOf(prefix) == -1) {
//            prefix = prefix.substring(0, prefix.length - 1)
//            if (prefix.isBlank()) {
//                return ""
//            }
//        }
//        i++
//    }
//    return prefix
//}

fun longestCommonPrefix(strs: Array<String>): String {
    return if (strs.isEmpty()) "" else longestCommonPrefix(strs, 0, strs.size - 1)
}

fun longestCommonPrefix(strs: Array<String>, l: Int, r: Int): String {
    return if (l == r) {
        strs[l]
    } else {
        val mid = (l + r) / 2
        val lcpLeft = longestCommonPrefix(strs, l, mid)
        val lcpRight = longestCommonPrefix(strs, mid + 1, r)
        commonPrefix(lcpLeft, lcpRight)
    }
}

fun commonPrefix(left: String, right: String): String {
    val min = Math.min(left.length, right.length)
    for (i in 0 until min) {
        if (left[i] != right[i]) return left.substring(0, i)
    }
    return left.substring(0, min)
}