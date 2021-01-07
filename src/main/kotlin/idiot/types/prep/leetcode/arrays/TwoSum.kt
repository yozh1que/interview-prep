package idiot.types.prep.leetcode.arrays
// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]
fun twoSum(nums: IntArray, target: Int): IntArray {
    val numMap = nums.mapIndexed { index, i -> i to index }.toMap()

    var i = 0
    while (i < nums.size) {
        if (numMap.containsKey(target - nums[i])) {
            return intArrayOf(i, numMap[target - nums[i]]!!)
        }
        i++
    }
    return intArrayOf()
}