/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var numSubarrayProductLessThanK = function(nums, k) {
    if(k <= 1) {
        return 0
    }
    var left = 0, right = 0, prod = 1, res = 0;
    while(right < nums.length) {
        prod = prod * nums[right];
        while(prod >= k) {
            prod /= nums[left];
            left += 1;
        }
        res += right - left + 1;
        right += 1;
    }
    return res;
};