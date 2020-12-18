var minSubArrayLen = function(s, nums) {
    if(nums.length == 0){
        return 0;
    }
    var len = nums.length;
    var res = len + 1;
    var start = 0, end = 0, curSum = 0;
    while(end < len) {
        curSum += nums[end];
        while(curSum >= s) {
            res = Math.min(res, end - start + 1);
            curSum -= nums[start];
            start += 1;
        } 
        end += 1;
    }
    return res == len + 1 ? 0 : res;
};