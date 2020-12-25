package TwoPointers.P930BinarySubarraysWithSum;

import java.util.HashMap;
import java.util.Map;

/**
 * @CLassName BinarySubarraysWithSum
 * @Description
 * In an array A of 0s and 1s, how many non-empty subarrays have sum S?
 *
 * Example 1:
 *
 * Input: A = [1,0,1,0,1], S = 2
 * Output: 4
 *
 * Note:
 * A.length <= 30000
 * 0 <= S <= A.length
 * A[i] is either 0 or 1.
 * @Author cst
 * @Date 12/20/20  2:44 PM
 */
public class BinarySubarraysWithSum {
    public int numSubarraysWithSum(int[] A, int S) {
        // In the interview, we could ask one edge case that if S is greater than A.length, what should return
        int res = 0;
        if (A.length < S) {
            return res;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int ptr = 0, preSum = 0;
        /**
         It is easy to see that,
         sum[i:j] = A[i] + A[i+1] ... + A[j] =
         (A[0] + A[1] + ... A[i] ... + A[j]) - (A[0] + A[1] + ... A[i-1]) =
         prefix[j] - prefix[i-1].

         Now we the problem reduces to finding # of pairs (i, j) (i < j) such that
         prefix[j] - prefix[i-1] = target
         **/
        while (ptr < A.length) {
            preSum += A[ptr];
            if (map.containsKey(preSum - S)) {
                res += map.get(preSum - S);
            }
            if (preSum == S) {
                res++;
            }
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
            ptr++;
        }
        return res;
    }
}
