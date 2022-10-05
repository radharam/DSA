package src.main.java.leetcode.sliding_window;

public class Solution {
        public static int lengthOfLongestSubstring(String s) {
            int n = s.length();
            int[] chars = new int[265];
            int end =0;
            int window = 0;
            for(int start=0; start<n; start++){
                int c = (int)s.charAt(start);
                chars[c] += 1;
                if(chars[c] > 1){
                    while(end <= start && chars[c] > 1){
                        int endChar = s.charAt(end);
                        chars[endChar] -= 1;
                        end += 1;
                    }
                }
                window = Math.max(window, start - end + 1);
                //if(window < start - end + 1)
            }
            return window;
        }

    public static void main(String[] args) {
        String s1 = "abcabcbb";
        String s2 = "bbbbb";
        int len = Solution.lengthOfLongestSubstring(s1);
        System.out.println(len);
    }
}
