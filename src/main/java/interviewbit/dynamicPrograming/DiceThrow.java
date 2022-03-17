package src.main.java.interviewbit.dynamicPrograming;

/*
Dice throw

Problem Description
Given sum A, number of ways you can get that sum with dice roll[1-6].
As the number of ways can be large return its modulo by 1e9 + 7.

Problem Constraints
1 <= A <= 10 2

Input Format
The first argument is the integer A.

Output Format

Return an integer .

Example Input
Input 1: A = 3
Input 2: A = 4

Example Output
Output 1: 4
Output 2: 8

Example Explanation
Explanation 1: The four possible ways to obtain 3 are: [1, 1, 1], [1, 2], [2, 1] and [3].
Explanation 2: The eight possible ways to obrain 8 are: [1, 1, 1, 1], [1, 1, 2], [1, 2, 1], [2, 1, 1], [1, 3], [3, 1], [2, 2], [4].
 */

public class DiceThrow {
    int M = (int) (1e9) + 7;
    public int solve(int A) {
        int[] dp = new int[A + 1];
        return computeWaysToGetTargetSum(A, 0, dp);
    }

    public int computeWaysToGetTargetSum(int targetSum, int currSum, int[] dp) {
        if(targetSum == currSum) return 1; //if target sum == curr sum, return 1
        if(currSum > targetSum) return 0; //if curr sum > target sum, return 0
        if(dp[currSum] != 0) return dp[currSum]; //if curr sum != 0, return val from dp

        int noOfWays = 0, index = 1; // compute noOfWays, noOfWays is the number of ways targetSum can be achieved
        while(index <= 6) { // check if index <= 6, the max valuje of dice
            noOfWays = (noOfWays%M + computeWaysToGetTargetSum(targetSum, currSum+index, dp)%M)%M; // compute no of ways we can achieve targetSum, keep adding the index to currSum n recursively call function, till you reach targetSum or cross it
            index += 1; // update index on backtracking
        }

        dp[currSum] = noOfWays; // update no of ways at given index
        return dp[currSum];
    }
}
