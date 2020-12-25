# P930 Binary Subarrays With Sum
## Two sum + prefix sum
- Why use prefix sum 

        presum[i] = arr[0] + arr[1] + arr[2] + ... + arr[i]

        presum[j] = arr[0] + arr[1] + ... + arr[i]+ ... + arr[j], where 0 <= j <= n-1

        Thus,

        sum[i:j] = presum[j] - presum[i]

- Use a Hashmap 

        To store presum(key) as well as the frequency of its occurrence(value)

## Time complexity
    We have to visit each value once so time complexity is O(N), where N is the length of the array. 

## Space complexity
    O(N), using a hashmap.



