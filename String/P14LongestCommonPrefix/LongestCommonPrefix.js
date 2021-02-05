var longestCommonPrefix = function(strs) {
    if(strs.length == 0){
        return ""
    }
    res = strs[0];
    idx = 1;
    while(idx < strs.length) {
        while(res != "" && !isPrefix(res, strs[idx])) {
            res = res.substring(0, res.length - 1)
        }
        idx++;
    }
    return res;
};

var isPrefix = function(prefix, str) {
    if (str.startsWith(res)) {
        return true;
    }
    return false;
};