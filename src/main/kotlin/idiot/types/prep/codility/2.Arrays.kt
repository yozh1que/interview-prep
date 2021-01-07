package idiot.types.prep.codility

//An array A consisting of N integers is given. Rotation of the array means that each element is shifted right by one index, and the last element of the array is moved to the first place. For example, the rotation of array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7] (elements are shifted right by one index and 6 is moved to the first place).
//
//The goal is to rotate array A K times; that is, each element of A will be shifted to the right K times.
//
//Write a function:
//
//class Solution { public int[] solution(int[] A, int K); }
//
//that, given an array A consisting of N integers and an integer K, returns the array A rotated K times.
//
//For example, given
//
//A = [3, 8, 9, 7, 6]
//K = 3
//the function should return [9, 7, 6, 3, 8]. Three rotations were made:
//
//[3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7]
//[6, 3, 8, 9, 7] -> [7, 6, 3, 8, 9]
//[7, 6, 3, 8, 9] -> [9, 7, 6, 3, 8]
//For another example, given
//
//A = [0, 0, 0]
//K = 1
//the function should return [0, 0, 0]
//
//Given
//
//A = [1, 2, 3, 4]
//K = 4
//the function should return [1, 2, 3, 4]
//
//Assume that:
//
//N and K are integers within the range [0..100];
//each element of array A is an integer within the range [−1,000..1,000].
//In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.


// O(gcd(N, K) * N / gcd) ~ O(N)
fun cyclicRotation(A: IntArray, K: Int): IntArray {
    val gcd = gcd(A.size, K)

    var i = 0
    var j = 0
    var step = 0
    var innerIters = A.size / gcd
    var tmp = 0
    while (i < gcd) {
        step = i
        j = 1
        while (j <= innerIters + 1) {
            var offset = (step + 1) * j * K

            tmp = A[offset % A.size].apply {
                if (tmp != 0) {
                    A[offset % A.size] = tmp
                }
            }
            j++
        }
        i++
    }
    return A
}

fun gcd(a: Int, b: Int): Int {
    return if (b == 0) {
        a
    } else {
        gcd(b, a % b)
    }
}

fun oddOccurrencesInArray(A: IntArray): Int {
    val occurencesMap = mutableMapOf<Int, Int>()

    A.forEach { occurencesMap.put(it, occurencesMap.getOrDefault(it, 0) + 1) }
    return occurencesMap.entries.first { it.value % 2 == 1 }.key
}

