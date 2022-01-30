package src.main.java.interviewbit.contest.fellowclassmate;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ReplaceNumbers {

    public int[] solve(int[] A, int[][] B) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            Set<Integer> list = map.getOrDefault(A[i], new HashSet<>());
            list.add(i);
            map.put(A[i], list);
        }
        Map<Integer, Set<Integer>> also = new HashMap<>();
        for (int key : map.keySet()) {
            Set<Integer> op = new HashSet<>();
            op.add(key);
            also.put(key, op);
        }
        for (int[] q : B) {
            Set<Integer> from = also.getOrDefault(q[0], new HashSet<>());
            Set<Integer> to = also.getOrDefault(q[1], new HashSet<>());
            to.addAll(from);
            also.remove(q[0]);
            also.put(q[1], to);
        }
        for (Map.Entry<Integer, Set<Integer>> entry : also.entrySet()) {
            for (int key : entry.getValue())
                for (int i : map.get(key))
                    A[i] = entry.getKey();
        }
        return A;
    }
}