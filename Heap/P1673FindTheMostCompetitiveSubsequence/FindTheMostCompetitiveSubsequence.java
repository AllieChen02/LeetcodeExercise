package Heap.P1673FindTheMostCompetitiveSubsequence;

import java.util.Stack;

/**
 * @CLassName FindTheMostCompetitiveSubsequence
 * @Description
 * Given an integer array nums and a positive integer k, return the most competitive subsequence of nums of size k.
 * An array's subsequence is a resulting sequence obtained by erasing some (possibly zero) elements from the array.
 *
 * We define that a subsequence a is more competitive than a subsequence b (of the same length) if in the first position where a and b differ, subsequence a has a number less than the corresponding number in b.
 * For example, [1,3,4] is more competitive than [1,3,5] because the first position they differ is at the final number, and 4 is less than 5.
 * Example 1:
 *
 * Input: nums = [3,5,2,6], k = 2
 * Output: [2,6]
 * Explanation: Among the set of every possible subsequence: {[3,5], [3,2], [3,6], [5,2], [5,6], [2,6]}, [2,6] is the most competitive.
 * @Author cst
 * @Date 5/23/21  10:32 PM
 */

public class FindTheMostCompetitiveSubsequence {
    // Keep a mono increasing stack .
    public static int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[k];
        for (int i = 0; i < nums.length ; i++) {
            // nums.length - i + stack.size()> k indicates that we still have elements in nums
            while (!stack.isEmpty() && nums[i] < nums[stack.peek()] && nums.length - i + stack.size() > k) {
                stack.pop();
            }
            if (stack.size() < k) {
                stack.push(i);
            }
        }
        // note: stack.size() is changing all the time, so CANNOT use int i = stack.size() - 1
        for (int i = k - 1; i >= 0; i--) {
            res[i] = nums[stack.pop()];
        }
        return res;
    }
}
