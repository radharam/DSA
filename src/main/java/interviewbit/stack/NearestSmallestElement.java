package src.main.java.interviewbit.stack;

/*
    Nearest Smaller Element
    Problem Description
    Given an array A, find the nearest smaller element G[i] for every element A[i] in the array such that the element has an index smaller than i.
    More formally,
    G[i] for an element A[i] = an element A[j] such that j is maximum possible AND j < i AND A[j] < A[i]
    Elements for which no smaller element exist, consider next smaller element as -1.

    Problem Constraints
    1 <= |A| <= 100000
    -109 <= A[i] <= 109

    Input Format
    The only argument given is integer array A.

    Output Format
    Return the integar array G such that G[i] contains nearest smaller number than A[i].If no such element occurs G[i] should be -1.

    Example Input
    Input 1: A = [4, 5, 2, 10, 8]
    Input 2: A = [3, 2, 1]

    Example Output
    Output 1: [-1, 4, -1, 2, 2]
    Output 2: [-1, -1, -1]

    Example Explanation
    Explanation 1:
    index 1: No element less than 4 in left of 4, G[1] = -1
    index 2: A[1] is only element less than A[2], G[2] = A[1]
    index 3: No element less than 2 in left of 2, G[3] = -1
    index 4: A[3] is nearest element which is less than A[4], G[4] = A[3]
    index 4: A[3] is nearest element which is less than A[5], G[5] = A[3]

    Explanation 2:
    index 1: No element less than 3 in left of 3, G[1] = -1
    index 2: No element less than 2 in left of 2, G[2] = -1
    index 3: No element less than 1 in left of 1, G[3] = -1
 */

import java.util.ArrayList;
import java.util.Stack;

public class NearestSmallestElement {

    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {

        return nearestSmaller(A);
    }

    public ArrayList<Integer> nearestSmaller(ArrayList<Integer> A) {
        int len = A.size();

        Stack<Integer> stack = new Stack<>(); // stores indexes
        ArrayList<Integer> nearestSmallerList = new ArrayList<>();

        // checks for nearest smaller elem for eacch elem in array
        for(int i = 0; i < len; i++) {

            // iterates to check for nearest smaller elem on left
            while(!stack.isEmpty()
                    && stack.peek() >= A.get(i)) stack.pop(); // is elem at top of stack is >= new elem in array, pop from stack

            if(stack.isEmpty()) nearestSmallerList.add(-1); // is no smaller elem, or stack is empty add -1
            else nearestSmallerList.add(stack.peek()); //if smaller elem there in stack add to array

            stack.push(A.get(i)); // push the next elem on to stack
        }

        return nearestSmallerList;
    }
}

