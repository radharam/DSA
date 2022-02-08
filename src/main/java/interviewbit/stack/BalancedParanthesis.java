package src.main.java.interviewbit.stack;

import java.util.Stack;

/*
    Balanced Parenthesis

    Problem Description
    Given an expression string A, examine whether the pairs and the orders of “{“,”}”, ”(“,”)”, ”[“,”]” are correct in A.
    Refer to the examples for more clarity.

    Problem Constraints
    1 <= |A| <= 100

    Input Format
    The first and the only argument of input contains the string A having the paranthesis sequence.

    Output Format
    Return 0, if the paranthesis sequence is not balanced.
    Return 1, if the paranthesis sequence is balanced.

    Example Input
    Input 1: A = {([])}
    Input 2: A = (){
    Input 3: A = ()[]

    Example Output
    Output 1: 1
    Output 2: 0
    Output 3: 1

    Example Explanation
    You can clearly see that the first and third case contain valid paranthesis.
    In the second case, there is no closing bracket for {, thus the paranthesis sequence is invalid.
 */

public class BalancedParanthesis {

    public int solve(String A) {

        return checkForBalancedParenthesis(A);
    }

    public int checkForBalancedParenthesis(String s) {
        int len = s.length();

        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < len; i++) {
            if(stack.isEmpty()) stack.push(s.charAt(i));
            else {
                String strObj = (new StringBuilder().append(stack.peek()).append(s.charAt(i))).toString();
                if(strObj.equals("()") || strObj.equals("{}")
                        || strObj.equals("[]")) {

                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            }
        }

        return (stack.isEmpty()) ? 1 : 0;
    }
}
