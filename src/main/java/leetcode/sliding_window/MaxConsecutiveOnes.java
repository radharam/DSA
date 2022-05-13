package src.main.java.leetcode.sliding_window;

// https://leetcode.com/problems/max-consecutive-ones-iii/
public class MaxConsecutiveOnes {
    public int longestOnes(int[] nums, int k) {
        int len = nums.length, countZero = 0, windowSize = 0;

        for(int s = 0, e = 0; (s < len && e <= s); s++) {
            if(nums[s] == 0) countZero++;
            while(countZero > k) {
                if(nums[e] == 0) countZero--;
                e++;
            }

            windowSize = Math.max(windowSize, s - e + 1);
        }

        return windowSize;
    }
}
