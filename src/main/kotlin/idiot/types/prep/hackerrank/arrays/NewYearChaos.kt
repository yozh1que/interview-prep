package idiot.types.prep.hackerrank.arrays


class Person(val id: Int) {
    var bribesLeft: Int = 2
}

fun minimumBribes(q: Array<Int>): Int {
    val bribesLeft = q.map { it to 2 }.toMap(mutableMapOf())

    var i = 1
    var holder: Int
    var bribes = 0

    // TODO:
    while (i < q.size) {
        if (q[i] < q[i-1]) {
            if (bribesLeft[q[i-1]]!! > 0) {
                bribes++
                bribesLeft[q[i-1]] = bribesLeft[q[i-1]]!! - 1
                holder = q[i]
                q[i] = q[i - 1]
                q[i - 1] = holder
            } else {
               return -1
            }
        }
        i++
    }

    return bribes
}