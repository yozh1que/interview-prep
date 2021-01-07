package idiot.types.prep.leetcode.arrays
// Input: [0,1,0,3,12]
// Output: [1,3,12,0,0]

fun moveZeroes(nums: IntArray): Unit {
    var i = 0
    var zeroes = 0
    while (i < nums.size) {
        if(nums[i] == 0) {
            zeroes++
        } else {
            nums[i-zeroes] = nums[i]
        }
        i++
    }
    while (zeroes > 0) {
        nums[nums.size - zeroes] = 0
        zeroes--
    }
}