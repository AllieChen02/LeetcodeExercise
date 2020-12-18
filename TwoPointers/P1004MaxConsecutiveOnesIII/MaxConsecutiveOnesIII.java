package TwoPointers.P1004MaxConsecutiveOnesIII;
/**
 * @Author cst
 * @Description
 * Given an array A of 0s and 1s, we may change up to K values from 0 to 1.
 *
 * Return the length of the longest (contiguous) subarray that contains only 1s.
 *
 * Example 1:
 *
 * Input: A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * Output: 6
 * Explanation:
 * [1,1,1,0,0,1,1,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.
 * Example 2:
 *
 * Input: A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 * Output: 10
 * Explanation:
 * [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.
 *
 * Note:
 *
 * 1 <= A.length <= 20000
 * 0 <= K <= A.length
 * A[i] is 0 or 1
 *
 * @Date 1:48 PM 12/18/20
 * @Param
 * @return
 **/
public class MaxConsecutiveOnesIII {
    public int longestOnes(int[] A, int K) {
        int res = 0;
        if (A == null || A.length == 0) {
            return res;
        }
        int start = 0, end = 0, count = 0;
        while (end < A.length) {
            if (A[end] == 0) {
                count++;
            }
            while (count > K) {
                // we have to move start pointer
                if (A[start] == 0){
                    count--;
                }
                start ++;
            }
            res = Math.max(res, end - start + 1);
            end++;
        }
        return res;
    }
}
