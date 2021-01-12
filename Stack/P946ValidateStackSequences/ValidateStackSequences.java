package Stack.P946ValidateStackSequences;

import java.util.Stack;

/**
 * @CLassName ValidateStackSequences
 * @Description TODO
 * @Author cst
 * @Date 1/11/21  10:19 PM
 */
public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length != popped.length) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int i = 0, j = 0;
        while (i < pushed.length) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j += 1;
            }
            i += 1;
        }
        return stack.isEmpty();
    }
}
