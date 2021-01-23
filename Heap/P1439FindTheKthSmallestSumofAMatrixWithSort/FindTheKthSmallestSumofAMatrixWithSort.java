package Heap.P1439FindTheKthSmallestSumofAMatrixWithSort;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @CLassName FindTheKthSmallestSumofAMatrixWithSort
 * @Description
 * You are given an m * n matrix, mat, and an integer k, which has its rows sorted in non-decreasing order.
 *
 * You are allowed to choose exactly 1 element from each row to form an array. Return the Kth smallest array sum among all possible arrays.
 * Example 1:
 *
 * Input: mat = [[1,3,11],[2,4,6]], k = 5
 * Output: 7
 * Explanation: Choosing one element from each row, the first k smallest sum are:
 * [1,2], [1,4], [3,2], [3,4], [1,6]. Where the 5th sum is 7.
 *
 * Example 2:
 * Input: mat = [[1,3,11],[2,4,6]], k = 9
 * Output: 17
 * @Author cst
 * @Date 1/21/21  12:25 AM
 */
public class FindTheKthSmallestSumofAMatrixWithSort {
    public int kthSmallest(int[][] mat, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(0);
        for (int[] row : mat) {
            PriorityQueue<Integer> tempPq = new PriorityQueue<>(Collections.reverseOrder());
            for (int val : pq) {
                for (int i=0; i < mat[0].length; i++) {
                    tempPq.add(val + row[i]);
                    if (tempPq.size() > k) {
                        tempPq.poll();
                    }
                }
            }
            pq = tempPq;
        }
        return pq.poll();
    }
}
