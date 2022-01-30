package src.main.java.interviewbit.contest.fellowclassmate;

import java.util.HashMap;
import java.util.Map;

public class WeirdFunction {

    private static final int MOD = (int) 1E9 + 7;

    public int sum(int N, int[] a) {
        long pf = 0;
        long ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            ans += (long) i * (long) a[i] - pf;
            pf += (long) a[i];
            int less = map.getOrDefault(a[i] - 1, 0);
            int more = map.getOrDefault(a[i] + 1, 0);
            ans -= (long) (less - more);
            ans = (ans + MOD) % MOD;
            map.merge(a[i], 1, Integer::sum);
        }
        ans = (ans + MOD) % MOD;
        return (int) ans;
    }
}