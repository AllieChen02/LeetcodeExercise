package TwoPointers.P845LongestMountainInArray;
/**
 * @Author cst
 * @Description
 * You may recall that an array arr is a mountain array if and only if:
 *
 * arr.length >= 3
 * There exists some index i (0-indexed) with 0 < i < arr.length - 1 such that:
 * arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
 * arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 * Given an integer array arr, return the length of the longest subarray, which is a mountain. Return 0 if there is no mountain subarray.
 *
 * Example 1:
 *
 * Input: arr = [2,1,4,7,3,2,5]
 * Output: 5
 * Explanation: The largest mountain is [1,4,7,3,2] which has length 5.
 * Example 2:
 *
 * Input: arr = [2,2,2]
 * Output: 0
 * Explanation: There is no mountain.
 *
 * @Date 2:32 PM 12/23/20
 * @Param
 * @return
 **/
public class LongestMountainInArray {
    public int longestMountain(int[] arr) {
        int res = 0;
        if(arr == null || arr.length < 3) {
            return res;
        }
        int[] ascArr = new int[arr.length];
        int[] desArr = new int[arr.length];
        for (int i = 1; i<arr.length; i++) {
            if (arr[i] > arr[i-1])
                ascArr[i] = ascArr[i-1] + 1;
        }

        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                desArr[i] = desArr[i+1] + 1;
            }
        }

        for (int i=0; i < ascArr.length; i++) {
            int temp = ascArr[i] + desArr[i] + 1;
            if (ascArr[i] != 0 && desArr[i] != 0 && temp >= 3)
                res = Math.max(res, temp);
        }
        return res;
    }

    // one pass
    public int longestMountain_1(int[] arr) {
        int res = 0, asc = 0, des = 0;
        if(arr == null || arr.length < 3) {
            return res;
        }
        for (int i=1; i<arr.length - 1; i++) {
            // [2,1,4] when arr[i-1] < arr[i] but desc != 0, it means that arr[i-1] is in another descending subarray
            if ((des > 0 && arr[i-1] < arr[i]) || (arr[i-1] == arr[i])) {
                asc = des = 0;
            }
            if (arr[i] > arr[i-1]) {
                asc++;
            }

            if (arr[i] > arr[i+1]) {
                des++;
            }
            if (asc > 0 && des > 0 && des + asc + 1 > 3) {
                res = Math.max(res, des + asc + 1);
            }
        }
        return res;
    }
}
