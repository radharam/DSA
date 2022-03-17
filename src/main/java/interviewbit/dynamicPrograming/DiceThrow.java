package src.main.java.interviewbit.dynamicPrograming;

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
