package src.main.java.interviewbit.stack;

import java.util.Stack;

/*
    Sort stack using another stack
    Problem Description
    Given a stack of integers A, sort it using another stack.
    Return the array of integers after sorting the stack using another stack.

    Problem Constraints
    1 <= |A| <= 5000
    0 <= A[i] <= 1000000000

    Input Format
    The only argument given is the integer array A.

    Output Format
    Return the array of integers after sorting the stack using another stack.

    Example Input
    Input 1: A = [5, 4, 3, 2, 1]
    Input 2: A = [5, 17, 100, 11]

    Example Output
    Output 1: [1, 2, 3, 4, 5]
    Output 2: [5, 11, 17, 100]

    Example Explanation
    Explanation 1: Just sort the given numbers.
    Explanation 2: Just sort the given numbers.
 */
public class StackSort {

    public int[] solve(int[] A) {

        return sortStack(A);
    }

    public int[] sortStack(int[] A) {
        int len = A.length;
        Stack<Integer> stack1 = new Stack<>(); // larger to small

        for(int n: A) stack1.push(n);

        Stack<Integer> stack2 = new Stack<>(); // small to large
        while(!stack1.isEmpty()) {
            int temp = stack1.pop();
            while(!stack2.isEmpty() && stack2.peek() > temp) {
                stack1.push(stack2.pop());
            }

            stack2.push(temp);
        }

        while(!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }

        int[] sortedList = new int[stack1.size()];
        int i = 0;
        while(!stack1.isEmpty()) {
            sortedList[i] = stack1.pop();
            i++;
        }

        return sortedList;
    }
}
