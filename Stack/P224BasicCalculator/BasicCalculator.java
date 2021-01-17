package Stack.P224BasicCalculator;

import java.util.Stack;

/**
 * @CLassName BasicCalculator
 * @Description TODO
 * @Author cst
 * @Date 1/12/21  11:01 PM
 */
public class BasicCalculator {
    private static BasicCalculator ONLY;

    public static BasicCalculator getONLY() {
        if (ONLY == null) {
            ONLY = new BasicCalculator();
        }
        return ONLY;
    }

    public int calculate(String s) {
        char[] ch = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        int sign = 1, num = 0, res = 0;
        for (int i = 0; i < ch.length; i++) {
            if (Character.isDigit(ch[i])) {
                num = num * 10 + ch[i] - '0';
            } else if (ch[i] == '+') {
                res += num * sign;
                sign = 1;
                num = 0;
            } else if (ch[i] == '-') {
                res += num * sign;
                sign = -1;
                num = 0;
            } else if (ch[i] == '(') {
                stack.push(res);
                stack.push(sign);
                sign = 1;
                num = 0;
                res = 0;
            } else if (ch[i] == ')') {
                res += num * sign;
                res *= stack.pop();
                res += stack.pop();
                sign = 1;
                num = 0;
            }
        }
        res += num * sign;
        return res;
    }
}
