package src.main.java.interviewbit.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
    Maximum Frequency stack
    Problem Description

    You are given a matrix A which represent operations of size N x 2. Assume initially you have a stack-like data structure you have to perform operations on it.
    Operations are of two types:
    1 x: push an integer x onto the stack and return -1
    2 0: remove and return the most frequent element in the stack.

    If there is a tie for the most frequent element, the element closest to the top of the stack is removed and returned.
    A[i][0] describes the type of operation to be performed. A[i][1] describe the element x or 0 corresponding to the operation performed.

    Problem Constraints
    1 <= N <= 100000
    1 <= A[i][0] <= 2
    0 <= A[i][1] <= 109

    Input Format
    The only argument given is the integer array A.

    Output Format
    Return the array of integers denoting answer to each operation.

    Example Input
    Input 1:
    A = [
                [1, 5]
                [1, 7]
                [1, 5]
                [1, 7]
                [1, 4]
                [1, 5]
                [2, 0]
                [2, 0]
                [2, 0]
                [2, 0]  ]

    Input 2:
     A =  [
            [1, 5]
            [2 0]
            [1 4]   ]

    Example Output

    Output 1: [-1, -1, -1, -1, -1, -1, 5, 7, 5, 4]
    Output 2: [-1, 5, -1]

    Example Explanation
    Explanation 1: Just simulate given operations
    Explanation 2: Just simulate given operations
 */
public class MaxFreqStack {
        public int[] solve(int[][] A) {

            return maxFreqStack(A);
        }

        public int[] maxFreqStack(int[][] A) {
            int len = A.length;
            int maxFreq = 0; // maintains max freq
            int[] outputOfOperations = new int[len]; // records push pop perations (push - -1, pop - popped val from stack)
            Map<Integer, Integer> elemFreqMap = new HashMap<>(); // freq for each elem
            Map<Integer, Stack<Integer>> freqStackMap = new HashMap<>(); // stack for each freq

        /*
            I Push
            1. add/update val of freq map
            2. add to freq stack, for given freq
            3. update maxFreq
            4. return -1 for push operation

            II Pop
            1. remove from max freq stack
            2. update/remove freq for val
            3. if maxFreq is removed from freq stack, update maxFreq
            4. return elem val for pop operation
        */
            for(int i = 0; i < len; i++) {
                if(A[i][0] == 1) {
                    elemFreqMap.put(A[i][1], elemFreqMap.getOrDefault(A[i][1], 0) +1); // add/update freq in freq map
                    int freq = elemFreqMap.get(A[i][1]); // get updated freq
                    maxFreq = Math.max(maxFreq, freq); // update max freq
                    Stack<Integer> st = freqStackMap.getOrDefault(freq, new Stack<Integer>()); // add to stack
                    st.push(A[i][1]);
                    freqStackMap.put(freq, st); // update add freqStack
                    outputOfOperations[i] = -1; // update with -1 for push operation
                } else if(A[i][0] == 2) {
                    Stack<Integer> st = freqStackMap.get(maxFreq); // get stack for maxfreq
                    int val = st.pop(); // pop val from maxFreq stack
                    outputOfOperations[i] = val; // update with elem val for pop operation
                    if(st.size() == 0) { // if stack size == 0
                        freqStackMap.remove(maxFreq); // remove maxFreq stack
                        maxFreq--; // update maxFreq
                    }
                    if(elemFreqMap.get(val) == 1) elemFreqMap.remove(val);  // freq for val == 1, remove freq map
                    else elemFreqMap.put(val, elemFreqMap.get(val)-1); // decr freq for given elem
                }
            }

            return outputOfOperations;
        }

}
