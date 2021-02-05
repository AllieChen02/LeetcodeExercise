/**
 * @param {string} s
 * @return {string}
 */
var longestPalindrome = function(s) {
    let res = "";
    for(let i =0; i<s.length; i++){
        let str1 = isPalind(s, i, i);
        let str2 = isPalind(s, i, i+1);
        let temp = str1.length > str2.length ? str1 : str2;
        res = res.length > temp.length ? res : temp;
    }
    return res;
};

const isPalind = function(s, left, right){
    while(left >= 0 && right <= s.length && s[left] == s[right]){
        left--;
        right++;
    }
    return s.substring(left + 1, right);
}