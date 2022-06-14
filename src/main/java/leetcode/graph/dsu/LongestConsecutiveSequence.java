package src.main.java.leetcode.graph.dsu;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;
        Map<Integer, Integer> mapOfNums = new HashMap<>();
        UnionFind uf = new UnionFind(len+1);
        for(int i = 0; i < len; i++) {
            if(mapOfNums.containsKey(nums[i])) continue;
            else mapOfNums.put(nums[i], i);

            if(mapOfNums.containsKey(nums[i]-1))
                uf.union(i, mapOfNums.get(nums[i]-1));

            if(mapOfNums.containsKey(nums[i]+1))
                uf.union(i, mapOfNums.get(nums[i]+1));
        }


        int maxSeq = uf.rank[0];

        for(int r: uf.rank) {
            maxSeq = Math.max(maxSeq, r);
        }

        return maxSeq;
    }

    class UnionFind {
        int[] parent;
        int[] rank;
        public UnionFind(int n) {
            this.parent = new int[n];
            this.rank = new int[n];
            for(int i = 0; i < n; i++) {
                this.parent[i] = i;
                this.rank[i] = 1;
            }
        }

        public void union(int x, int y) {
            if ((x == -1) || (y == -1)) return;
            int px = find(x);
            int py = find(y);

            if(px == py) return;

            if(this.rank[px] >= this.rank[py]) {
                this.parent[py] = px;
                this.rank[px] += rank[py];
            } else {
                this.parent[px] = py;
                this.rank[py] += rank[px];
            }
        }

        public int find(int x) {
            if(x != this.parent[x]) this.parent[x] = find(this.parent[x]);
            return this. parent[x];
        }
    }

}
