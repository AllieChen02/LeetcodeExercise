/**
 * @param {number} n
 * @return {string}
 */
var countAndSay = function(n) {
    if(n == 1) {
        return "1";
    }
    res = "1";
    for(var i = 1; i < n; i++) {
        var ch = [...res];
        var curr = ch[0];
        var count = 0;
        var temp = ""
        for(var j = 0; j < ch.length; j++ ){
            if(ch[j] == curr) {
                count += 1;
            } else{
                temp += count + curr;
                count = 1;
                curr = ch[j]
            }
        }
        res = temp;
    }
    return res;
};