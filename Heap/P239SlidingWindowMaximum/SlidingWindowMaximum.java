package Heap.P239SlidingWindowMaximum;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @CLassName SlidingWindowMaximum
 * @Description TODO
 * @Author cst
 * @Date 1/21/21  12:18 AM
 */
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return new int[]{};
        }
        int len = nums.length;
        //用来存储元素角标位置
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[len - k  + 1];
        for (int i=0; i < len; i++){
            //当要加入当元素大于队尾元素时，我们将里面东西弹出来
            while(!deque.isEmpty() && nums[deque.getLast()] <= nums[i]){
                deque.removeLast();
            }
            deque.add(i);
            if(deque.getFirst() == i - k){
                //we have reaches its capacity
                deque.removeFirst();
            }
            if(i>= k-1){
                res[i-k+1] = nums[deque.getFirst()];
            }
        }
        return res;
    }
}
