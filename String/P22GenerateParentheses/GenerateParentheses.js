/**
 * @param {number} n
 * @return {string[]}
 */
var generateParenthesis = function(n) {
    var res = [];
    backtrack(res, n, 0, 0, "");  
    return res;      
};

var backtrack = function(res, n, left, right, str) {
    if(str.length == 2 * n) {
        if(left == n && right == n) {
            res.push(str);
        }
        return;
    }
    if(left < n) {
        str += '(';
        backtrack(res, n, left + 1, right, str);
        str = str.slice(0, -1);
    }
    if(right < left) {
        str += ')';
        backtrack(res, n, left, right+1, str);
        str = str.slice(0, -1);
    }
};