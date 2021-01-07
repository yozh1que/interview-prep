package idiot.types.algs1

// Sorts an array by repeatedly finding the minimum element (considering ascending order) from unsorted
// part and putting it at the beginning. The algorithm maintains two subarrays in a given array.
//
// Time Complexity: O(n2) as there are two nested loops.
//
// Auxiliary Space: O(1)

// The good thing about selection sort is it never makes more than O(n) swaps and can be useful when memory write is a costly operation.

// https://www.geeksforgeeks.org/selection-sort/
fun <T> selectionSort(arr: Array<Comparable<T>>): Array<Comparable<T>> {

    var i = 0

    while (i < arr.size) {
        var j = i + 1
        // index of the min value in the unsorted right part of the arr
        var minValIndex = i
        while (j < arr.size) {
            minValIndex = j.takeIf { compareValues(arr[j], arr[minValIndex]) <= 0 } ?: minValIndex
            j++
        }
        if (minValIndex != i) {
            arr[minValIndex].apply {
                arr[minValIndex] = arr[i]
                arr[i] = this
            }
        }
        i++
    }

    return arr
}

fun <T> insertionSort(arr: Array<Comparable<T>>): Array<Comparable<T>> {
    TODO()
}
