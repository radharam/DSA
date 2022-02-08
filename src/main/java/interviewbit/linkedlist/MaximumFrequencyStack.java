package src.main.java.interviewbit.linkedlist;

import java.util.*;

public class MaximumFrequencyStack {

    /*public static void main(String[] args) {
        int[][] A = new int[][] {{1, 5}, {1, 7}, {1, 5}, {1, 7}, {1, 4}, {1, 5}, {2, 0}, {2, 0}, {2, 0}, {2, 0}};
        int[] output = solve(A);
        System.out.printf("output: %s", Arrays.toString(output));
    }*/

    public static int[] solve(int[][] A) {

        return maxFreqStack(A);
    }

    public static int[] maxFreqStack(int[][] A) {
        int len = A.length, maxFreq = -1;

        int[] output = new int[len];
        Stack<Integer> stack = new Stack<>(), maxFreqStack = new Stack<>();
        Map<Integer, Integer> freq = new HashMap<>(); //, maxFreqTopElem = new HashMap<>(1);

        for(int i = 0; i < len; i++) {
            if(A[i][0] == 1) {
                stack.push(A[i][1]);
                freq.put(A[i][1], freq.getOrDefault(A[i][1], 0) + 1);
                if(maxFreq <= freq.get(A[i][1])) {
                    maxFreq = freq.get(A[i][1]);
                    maxFreqStack.push(A[i][1]);
                } else {
                    System.out.printf("peek: %d\t",maxFreqStack.peek());
                    maxFreqStack.push(maxFreqStack.peek());
                }
                System.out.printf("output: %s;\t", Arrays.toString(output));
                output[i] = -1;
            } else if(A[i][0] == 2) {
                stack.pop();
                output[i] = stack.peek();
                maxFreqStack.pop();
            }
        }

        return output;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(5);
        list.set(2, 4);

        System.out.printf("%s", list.toString());
    }
}

