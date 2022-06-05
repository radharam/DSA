package src.main.java.leetcode.sliding_window;

// https://leetcode.com/problems/minimum-size-subarray-sum/
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length, targetSum = target, windowSize = len+1;

        for(int s = 0, e = 0; (s < len && e <= s); s++) {
            targetSum -= nums[s];

            while(targetSum <= 0) {
                windowSize = Math.min(windowSize, (s - e + 1));
                targetSum += nums[e];
                e++;
            }
        }

        return windowSize%(len+1);
    }
}
