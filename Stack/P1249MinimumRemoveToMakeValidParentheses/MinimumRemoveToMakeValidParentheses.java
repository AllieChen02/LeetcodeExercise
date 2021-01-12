package Stack.P1249MinimumRemoveToMakeValidParentheses;

import java.util.Stack;

/**
 * @CLassName MinimumRemoveToMakeValidParentheses
 * @Description TODO
 * @Author cst
 * @Date 1/10/21  3:29 PM
 */
public class MinimumRemoveToMakeValidParentheses {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == '(')
                stack.push(i);
            else if(chs[i] == ')'){
                if (stack.empty()) {
                    chs[i] = ' ';
                } else {
                    stack.pop();
                }
            }
        }
        while(!stack.isEmpty()) {
            chs[stack.pop()] = ' ';
        }
        return new String(chs).replaceAll(" ", "");
    }
}
