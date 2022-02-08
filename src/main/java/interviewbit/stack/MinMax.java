package src.main.java.interviewbit.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
    MIN and MAX
    Problem Description
    Given an array of integers A, value of a array = max(array) - min(array).
    Calculate and return the sum of values of all possible subarrays of A % 109+7.

    Problem Constraints
    1 <= |A| <= 100000
    1 <= A[i] <= 1000000

    Input Format
    The first and only argument given is the integer array A.

    Output Format
    Return the sum of values of all possible subarrays of A % 10^9+7.

    Example Input
    Input 1: A = [1]
    Input 2: A = [4, 7, 3, 8]

    Example Output
    Output 1: 0
    Output 2: 26

    Example Explanation
    Explanation 1:
    Only 1 subarray exists. Its value is 0.

    Explanation 2:
    value ( [4] ) = 4 - 4 = 0
    value ( [7] ) = 7 - 7 = 0
    value ( [3] ) = 3 - 3 = 0
    value ( [8] ) = 8 - 8 = 0
    value ( [4, 7] ) = 7 - 4 = 3
    value ( [7, 3] ) = 7 - 3 = 4
    value ( [3, 8] ) = 8 - 3 = 5
    value ( [4, 7, 3] ) = 7 - 3 = 4
    value ( [7, 3, 8] ) = 8 - 3 = 5
    value ( [4, 7, 3, 8] ) = 8 - 3 = 5
    sum of values % 10^9+7 = 26
 */
public class MinMax {

    public int solve(ArrayList<Integer> A) {

        return sumOfMinMax(A);
    }

    public int sumOfMinMax(ArrayList<Integer> A) {
        int len = A.size();

        if(len == 1) return 0;

        long minCount = 0, maxCount = 0, res = 0, M = (long) (1e9) + 7;
        List<Integer> minLeft = new ArrayList<>(len+1), maxLeft = new ArrayList<>(len+1);
        List<Integer> minRight = new ArrayList<>(len+1), maxRight = new ArrayList<>(len+1);
        findMinMaxLeftOfElem(A, minLeft, maxLeft);
        findMinMaxRightOfElem(A, minRight, maxRight);

        for(int i = 0; i < len; i++) {
            int minj = minLeft.get(i);
            int mink = minRight.get(len - 1 - i);
            minCount = (long) 1L * (i - minj) * (mink - i);

            int maxj = maxLeft.get(i);
            int maxk = maxRight.get(len - 1 - i);
            maxCount = (long) 1L * (i - maxj) * (maxk - i);

            res = (long) (((maxCount - minCount) * A.get(i)%M)%M + res%M);
        }

        return (int) ((res + M) % M);
    }

    public void findMinMaxLeftOfElem(ArrayList<Integer> A, List<Integer> minLeft, List<Integer> maxLeft) {
        int len = A.size(), leftMostIndex = -1;

        Stack<Integer> st1 = new Stack<>(), st2 = new Stack<>();
        for(int i = 0; i < len; i++) {
            // minimum Left
            while(!st1.isEmpty() && A.get(st1.peek()) >= A.get(i)) st1.pop();

            if(st1.isEmpty()) minLeft.add(leftMostIndex);
            else minLeft.add(st1.peek());

            st1.push(i);

            // maximum Left
            while(!st2.isEmpty() && A.get(st2.peek()) <= A.get(i)) st2.pop();

            if(st2.isEmpty()) maxLeft.add(leftMostIndex);
            else maxLeft.add(st2.peek());

            st2.push(i);
        }

        //System.out.printf("minLeft: %s; maxLeft: %s;\t", minLeft, maxLeft);
    }

    public void findMinMaxRightOfElem(ArrayList<Integer> A, List<Integer> minRight, List<Integer> maxRight) {
        int len = A.size(), rightMostIndex = len;

        Stack<Integer> st1 = new Stack<>(), st2 = new Stack<>();
        for(int i = len-1; i >= 0; i--) {
            // minimum Right
            while(!st1.isEmpty() && A.get(st1.peek()) >= A.get(i)) st1.pop();

            if(st1.isEmpty()) minRight.add(rightMostIndex);
            else minRight.add(st1.peek());

            st1.push(i);

            // maximum Right
            while(!st2.isEmpty() && A.get(st2.peek()) <= A.get(i)) st2.pop();

            if(st2.isEmpty()) maxRight.add(rightMostIndex);
            else maxRight.add(st2.peek());

            st2.push(i);
        }

    }
}

