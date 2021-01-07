package idiot.types.prep.leetcode.arrays


// Given nums = [0,0,1,1,1,2,2,3,3,4],

// Your function should return length = 5,
// with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively
fun removeDuplicates(nums: IntArray): Int {
    var i = 1
    var length = 1
    var duplicateStart = 1
    while (i < nums.size) {
        if (nums[i-1] != nums[i]) {
            nums[duplicateStart] = nums[i]
            duplicateStart++
            length++
        }
        i++
    }
    return length
}
