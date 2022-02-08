package src.main.java.interviewbit.stack;

import java.util.Stack;


/*
    Maximum Rectangle
    Given a 2D binary matrix of integers A containing 0's and 1's of size N x M.
    Find the largest rectangle containing only 1's and return its area.
    Note: Rows are numbered from top to bottom and columns are numbered from left to right.

    Input Format
    The only argument given is the integer matrix A.

    Output Format
    Return the area of the largest rectangle containing only 1's.

    Constraints
    1 <= N, M <= 1000
    0 <= A[i] <= 1
    For Example

    Input 1: A = [   [0, 0, 1]
                [0, 1, 1]
                [1, 1, 1]   ]
    Output 1: 4

    Input 2: A = [   [0, 1, 0, 1]
                [1, 0, 1, 0]    ]
    Output 2: 1
 */

public class MaximumRectangle {

    public int solve(int[][] A) {
        int rowLen = A.length, colLen = A[0].length, maxArea = -1;
        int[][] minLeft = new int[rowLen][colLen], minRight = new int[rowLen][colLen], sumRow = new int[rowLen][colLen];

        sumRow = computeHeightForEachRow(A);
        //sumCol = computeHeightForEachCol(sumRow);
        for(int i = 0; i < rowLen; i++) {
            minLeft[i] = findMinLeft(sumRow[i]);
            minRight[i] = findMinRight(sumRow[i]);
        } //TC: O(N)

        for(int i = 0; i < rowLen; i++) {
            for(int j = 0; j < colLen; j++) {
                maxArea = Math.max(maxArea, (minRight[i][j] - minLeft[i][j] - 1) * sumRow[i][j]);
            }
        } //TC: O(N*M)

        return maxArea;
    }

    public int[][] computeHeightForEachRow(int[][] A) {
        int rowLen = A.length, colLen = A[0].length;
        int[][] sumRow = new int[rowLen][colLen];
        sumRow[0] = A[0];
        for(int i = 1; i < rowLen; i++) {
            for(int j = 0; j < colLen; j++) {
                if(A[i][j] != 0) sumRow[i][j] = sumRow[i-1][j] + A[i][j];
            }
        }

        return sumRow;
    }

    public int[] findMinLeft(int[] row) {
        int len = row.length, leftMostIndex = -1;
        int[] minLeft = new int[len];

        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < len; i++) {
            while(!st.isEmpty() && row[st.peek()] >= row[i]) st.pop();

            if(st.isEmpty()) minLeft[i] = leftMostIndex;
            else minLeft[i] = st.peek();

            st.push(i);
        }

        return minLeft;
    }

    public int[] findMinRight(int[] row) {
        int len = row.length, rightMostIndex = len;
        int[] minRight = new int[len];

        Stack<Integer> st = new Stack<>();
        for(int i = len-1; i >= 0; i--) {
            while(!st.isEmpty() && row[st.peek()] >= row[i]) st.pop();

            if(st.isEmpty()) minRight[i] = rightMostIndex;
            else minRight[i] = st.peek();

            st.push(i);
        }

        return minRight;
    }
}

