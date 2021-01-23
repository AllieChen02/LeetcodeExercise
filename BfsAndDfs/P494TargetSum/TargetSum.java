package BfsAndDfs.P494TargetSum;

/**
 * @CLassName TargetSum
 * @Description
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
 *
 * Find out how many ways to assign symbols to make sum of integers equal to target S.
 *
 * Example 1:
 *
 * Input: nums is [1, 1, 1, 1, 1], S is 3.
 * Output: 5
 * Explanation:
 *
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 *
 * There are 5 ways to assign symbols to make the sum of nums be target 3.
 * @Author cst
 * @Date 1/21/21  1:27 PM
 */
public class TargetSum {
    private int res = 0;
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) {
            return res;
        }
        helper(nums, S, 0, 0);
        return res;
    }

    public void helper(int[] nums, int target, int idx, int curSum) {
        if (idx == nums.length) {
            if (target == curSum) {
                res += 1;
            }
            return;
        }

        helper(nums, target, idx + 1, curSum + nums[idx]);
        helper(nums, target, idx + 1, curSum - nums[idx]);
    }
}
