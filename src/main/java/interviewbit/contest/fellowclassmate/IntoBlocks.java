package src.main.java.interviewbit.contest.fellowclassmate;

import java.util.HashMap;
import java.util.Map;

public class IntoBlocks {
    public int solve(int[] A) {
        Map<Integer, Integer> last = new HashMap<>();
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            last.put(A[i], i);
        }
        int res = 0;
        int start = 0;
        int lastIdx = -1;
        for (int i = 0; i < A.length; i++) {
            freq.merge(A[i], 1, Integer::sum);
            int nLastIdx = last.get(A[i]);
            if (nLastIdx > lastIdx) {
                lastIdx = nLastIdx;
            }
            if (i == lastIdx) {
                res += (lastIdx - start + 1) - maxCount(freq);
                freq.clear();
                start = i + 1;
            }
        }
        return res;
    }

    private int maxCount(Map<Integer, Integer> map) {
        int x = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            x = Math.max(x, entry.getValue());
        }
        return x;
    }
}
