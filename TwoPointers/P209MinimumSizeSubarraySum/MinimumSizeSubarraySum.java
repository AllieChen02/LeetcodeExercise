package TwoPointers.P209MinimumSizeSubarraySum;
/**
 * @Author cst
 * @Description
 *
 * Given an array of n positive integers and a positive integer s,
 * find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 *
 * Example:
 *
 * Input: s = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 * Follow up:
 * If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
 * @Date 12:52 PM 12/18/20
 * @Param
 * @return
 **/
public class MinimumSizeSubarraySum {

    // time complexit: O(N)
    public int minSubArrayLen(int s, int[] nums) {
        // edge case
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = nums.length + 1;
        int idx = 0, start = 0, curSum = 0;
        while (idx < nums.length) {
            curSum += nums[idx];
            while (curSum >= s) {
                res = Math.min(res, idx - start + 1);
                curSum -= nums[start];
                start++;
            }
            idx++;
        }
        return res == nums.length + 1 ? 0 : res;
    }
}
