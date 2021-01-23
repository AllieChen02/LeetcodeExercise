package Stack.P316RemoveDuplicateLetters;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @CLassName RemoveDuplicateLetters
 * @Description TODO
 * @Author cst
 * @Date 1/18/21  10:57 AM
 */
public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int[] count = new int[26]; // count the number of occurences of character
        char[] ch = s.toCharArray();
        Set<Character> set = new HashSet<>();
        Stack<Character> stack = new Stack<>();
        // count occurences
        for (char c : ch) {
            count[c-'a']++;
        }

        for (char c : ch) {
            count[c - 'a']--;
            // if character is already present in stack, continue
            if (set.contains(c)) {
                continue;
            }
            // if current character is greater than the last character in stack which would also appear later,
            // we could pop the last character now.
            while (!stack.isEmpty() && stack.peek() > c && count[stack.peek() - 'a'] != 0) {
                set.remove(stack.pop());
            }
            stack.push(c);
            set.add(c);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
}
