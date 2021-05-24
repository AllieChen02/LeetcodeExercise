package Heap.P1675MinimizeDeviationInArray;

import java.util.PriorityQueue;

/**
 * @CLassName MinimizeDeviationInArray
 * @Description
 * You are given an array nums of n positive integers.
 *
 * You can perform two types of operations on any element of the array any number of times:
 *
 * If the element is even, divide it by 2.
 * For example, if the array is [1,2,3,4], then you can do this operation on the last element, and the array will be [1,2,3,2].
 * If the element is odd, multiply it by 2.
 * For example, if the array is [1,2,3,4], then you can do this operation on the first element, and the array will be [2,2,3,4].
 * The deviation of the array is the maximum difference between any two elements in the array.
 *
 * Return the minimum deviation the array can have after performing some number of operations.
 * Example 1:
 *
 * Input: nums = [1,2,3,4]
 * Output: 1
 * Explanation: You can transform the array to [1,2,3,2], then to [2,2,3,2], then the deviation will be 3 - 2 = 1.
 * Example 2:
 *
 * Input: nums = [4,1,5,20,3]
 * Output: 3
 * Explanation: You can transform the array after two operations to [4,2,5,5,3], then the deviation will be 5 - 2 = 3.
 * Example 3:
 *
 * Input: nums = [2,10,8]
 * Output: 3
 * @Author cst
 * @Date 5/23/21  9:42 PM
 */
public class MinimizeDeviationInArray {
    /*
    https://leetcode.com/problems/minimize-deviation-in-array/discuss/1044718/simple-java-solution-with-explaination-using-heap
    * step 1: convert all odd number to even (*2) and add to the priority queue.
    *         It can help to eliminate one operation. At the same time, record the minimum number in the array
    * step 2: Get max element from heap and calculate diff=Math.min(max-min).
    *         In this way we will maintain minimum diff everytime. Now if current element is even just add num/2 again into heap.
    *         And update min by checking if num/2 is less then current min.
    */
    public static int minimumDeviation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        int min = Integer.MAX_VALUE;
        int res = min;
        // eliminate odd number to make sure array only needs one operation
        for (int num : nums) {
            if (num % 2 == 1) {
                num = num * 2; // convert odd to even number
            }
            min = Math.min(min, num);
            pq.offer(num);
        }

        // decrease the max deviation
        while (!pq.isEmpty()) {
            int temp = pq.poll();
            res = Math.min(res, temp - min);
            // we cannot further decrease the max deviation if max element itself is odd.
            if (temp % 2 == 1) {
                break;
            }
            pq.offer(temp / 2);
            min = Math.min(min, temp / 2);
        }
        return res;
    }
}
