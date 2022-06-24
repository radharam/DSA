/*
    https://leetcode.com/problems/redundant-connection
    684. Redundant Connection
    
    TC: O(N)
    SC: O(N)

*/
public class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        
        UnionFind uf = new UnionFind(edges.length+1);
        for(int[] edge: edges) {
            if(uf.find(edge[0]) == uf.find(edge[1])) return edge;
            uf.union(edge[0], edge[1]);
        }
        
        throw new AssertionError();
    }
    
    class UnionFind {
        int[] parent;
        int[] rank;
        public UnionFind (int n) {
            parent = new int[n]; // set size
            rank = new int[n];  // set size
            
            for(int i = 0; i < n; i++) {
                parent[i] = i; // all parents are indexes
                rank[i] = 1;  // all ranks are 1 initially 
            }
        }

        public void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            
            if(px == py) return;
            
            if(rank[px] >= rank[py]) {
                this.parent[py] = px;
                this.rank[px] += this.rank[py];
            } else {
                this.parent[px] = py;
                this.rank[py] += this.rank[px];
            }
        }
        
        public int find(int x) {
            if(x != this.parent[x]) this.parent[x] = find(this.parent[x]);
            
            return this.parent[x];
        }
        
    }
}
