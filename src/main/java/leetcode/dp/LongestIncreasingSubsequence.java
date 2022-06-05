package src.main.java.leetcode.dp;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int len = 0;
        for(int num : nums){
            int i= Arrays.binarySearch(dp, 0, len, num);
            if(i<0) i = -(i+1);
            dp[i] = num;
            if(i==len) len += 1;
        }
        return len;
    }
}
// [10,9,2,5,3,7,101,18]
/*
num 10 9 2 5
idx     0
dp      2
len 0 1



 */