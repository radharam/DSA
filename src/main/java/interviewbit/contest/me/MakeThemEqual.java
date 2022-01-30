package src.main.java.interviewbit.contest.me;

import java.util.HashMap;
import java.util.Map;

public class MakeThemEqual {

    public int makeThemEqual(int[] A) {
        // maintain a map to check for equal floors n check for map with freq equal to length of A, n check for max number

        // to get eq freq, has to be <= min num in array

        int len = A.length, maxKey = Integer.MIN_VALUE;;
        Map<Integer, Integer> freqOfFloor = new HashMap<>();
        for(int i = 0; i < len; i++) {

            int val = A[i];
            freqOfFloor.put(val, freqOfFloor.getOrDefault(val, 0) +1);
            while(val > 1) {
                val = (int)Math.floor(val>>1);
                freqOfFloor.put(val, freqOfFloor.getOrDefault(val, 0) +1);
                if(freqOfFloor.get(val) == len) maxKey = Math.max(maxKey, val);
            }
        }

        int ans = 0;
        for(int n: A) {
            while(n != maxKey) {
                n >>= 1;
                ans++;
            }
        }

        return ans;
    }

    public int makeThemEqual2(int[] A){
        int len = A.length;
        int minVal = A[0];

        for(int i = 1; i < len; i++){
            int val = A[i];
            while(minVal != val){
                if(minVal < val)
                    val >>= 1;
                else
                    minVal >>= 1;

            }
        }

        int operations_count = 0;
        for(int i = 0; i < len; i++){
            if(A[i] == minVal) continue;
            while(A[i] != minVal){
                A[i]>>=1;
                operations_count++;
            }
        }

        return operations_count;
    }
}
