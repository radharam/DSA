package src.main.java;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int n =6;
        long Arr[] = {7,1,5,3,6,4};

        System.out.println("The maximum profit that can be generated is "+getMaximumProfit(Arr, n));

       /* int[][] arr = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        minFallingPathSum(arr);*/
    }

    static long getMaximumProfit(long Arr[], int n)
    {
        //Write your code here

        long dp[][]=new long[n+1][2];
        for(long row[]: dp)
            Arrays.fill(row,-1);

        //base condition
        dp[n][0] = dp[n][1] = 0;

        long profit=0;

        for(int ind= n-1; ind>=0; ind--){
            for(int buy=0; buy<=1; buy++){
                if(buy==0){// We can buy the stock
                    profit = Math.max(0+dp[ind+1][0], -Arr[ind] + dp[ind+1][1]);
                }

                if(buy==1){// We can sell the stock
                    profit = Math.max(0+dp[ind+1][1], Arr[ind] + dp[ind+1][0]);
                }

                dp[ind][buy]  = profit;
            }
        }
        return dp[0][0];
    }

    public static int minFallingPathSum(int[][] arr) {

		/* Given 2D array ;
		[[1,2,3],
		[4,5,6],
		[7,8,9]]
		*/

        for(int i=1;i<arr.length;i++){

            for(int j=0;j<arr[0].length;j++){
                int min=Integer.MAX_VALUE;
                for(int k=0;k<arr[0].length;k++){

                    if(k != j && arr[i-1][k] < min){
                        min = arr[i-1][k];
                    }
                }

                arr[i][j] += min;
            }

        }
    /*
	Updated 2D array ;
		[[1,2,3],
		[6,6,7],
		[13,14,15]]

		*/

        int[] lastRow = arr[arr.length-1];
        int min = Integer.MAX_VALUE;
        for(int i:lastRow){
            if(i< min){
                min = i;
            }
        }
        return min;
    }
}
