/**
 * @param {string} digits
 * @return {string[]}
 */
var letterCombinations = function(digits) {
    if(digits.length == 0) {
        return []
    }
    var alph = ["", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"]
    res = [""];
    for(var ch of digits){
        res = combine(res, alph[parseInt(ch)]);
    }
    return res;
};

const combine = function(res, c) {
    temp = [];
    for(var ch of c) {
        for(var str of res) {
            temp.push(str + ch);
        }
    }
    return temp;
};