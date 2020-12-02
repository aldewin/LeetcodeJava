package easy;

import java.util.Stack;

/**
 * 20. Valid Parentheses
 *
 * https://leetcode.com/problems/valid-parentheses/
 */

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }


    // Time complexity: O(n), Space Complexity: O(n)
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '[')
                stack.push(']');
            else if (c == '{')
                stack.push('}');
            else {
                if (stack.empty())
                    return false;
                if (stack.pop() != c)
                    return false;
            }
        }
        return stack.empty();
    }
}
