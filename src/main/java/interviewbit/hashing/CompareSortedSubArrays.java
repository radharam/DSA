package src.main.java.interviewbit.hashing;

import java.util.*;
// testing
public class CompareSortedSubArrays {
    Set<Long> hashVal = new HashSet<>();
    Map<Integer, Long> mapOfHash = new HashMap<>();
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {

        return compareSortedSubArrayWithHashing(A, B);
    }

    public ArrayList<Integer> compareSortedSubArrayWithHashing(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
        int lenA = A.size();
        int lenB = B.size();

        createHash(A);
        long[] prefixA = new long[lenA+1];

        prefixA[0] = mapOfHash.get(0);
        for(int i = 1; i < lenA; i++) {
            prefixA[i] = prefixA[i-1] + mapOfHash.get(A.get(i));
        }

        ArrayList<Integer> res = new ArrayList<>();
        for(ArrayList<Integer> q: B) {

            //long subArraySum1 = prefixA[q.get(1)] - ((q.get(0) == 0) ? 0 : prefixA[q.get(0)-1]);
            //long subArraySum2 = prefixA[q.get(3)] - ((q.get(2) == 0) ? 0 : prefixA[q.get(2)-1]);
            long subArraySum1 = prefixA[q.get(1)]+1 - prefixA[q.get(0)];
            long subArraySum2 = prefixA[q.get(3)]+1 - prefixA[q.get(2)];

            System.out.printf("subArraySum1: %d; subArraySum2: %d;\t", subArraySum1, subArraySum2);
            System.out.printf("q.get(0): %d; q.get(1): %d; q.get(2): %d; q.get(0): %d;\t",
                    prefixA[q.get(0)], prefixA[q.get(1)], prefixA[q.get(2)], prefixA[q.get(3)]);
            res.add((subArraySum1 != subArraySum2) ? 0 : 1);
        }

        return res;
    }

    public void createHash(ArrayList<Integer> A) {

        Random rd = new Random();
        long hash = rd.nextInt();
        mapOfHash.put(0, hash);
        for(int i = 0; i < A.size(); i++) {
            if (!mapOfHash.containsKey(A.get(i))) {
                hash = rd.nextInt();
                while (hashVal.contains(hash)) {
                    hash = rd.nextInt();
                }

                mapOfHash.put(A.get(i), hash);
                hashVal.add(hash);
            }
        }
        /*int len = A.size(), min = 1, max = (int) 100003, range = max - min + 1;

        long val = (long)((Math.random()%range)*range);
        mapOfHash.put(0, val);
        hashVal.add(val);
        for(int i = 0; i < len; i++) {

            if(!mapOfHash.containsKey(A.get(i))) {
                val = (long)((Math.random()%range) * range);
                while(hashVal.contains(val)) val = (long)((Math.random()%range)*range);

                mapOfHash.put(A.get(i), val);
                hashVal.add(val);
            }
        } */
    }
}
