/**
 * @param {string} s
 * @return {number}
 */
var calculate = function(s) {
    var res = 0;
    var stack = [];
    // remove space
    s = s.replace(/\s/g, '');
    const arr = [...s];
    var num = 0;
    var sign = '+';
    for (let i = 0; i  < arr.length; i++) {
        if(/\d/.test(arr[i])) {
            num = num * 10 + Number(arr[i]);
        }
        if (/\D/.test(arr[i])|| i == arr.length - 1) {
            if (sign === '+') {
                stack.push(num)
            } else if(sign == '-') {
                stack.push(-num)
            } else if(sign === '/') {
                stack.push(~~(stack.pop() / num))
            } else if(sign == '*') {
                stack.push(stack.pop() * num)
            }
            num = 0;
            sign = arr[i]
        }
    }
    return stack.reduce((a, b) => a + b);
};