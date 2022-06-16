
/*
  https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
  323. Number of Connected Components in an Undirected Graph

*/

public Class NumberConnectedComponentsUndirectedGraph {
    
   // path compression, rank hueristic
    class UnionFind {
        int[] parent;
        int[] rank;
        public UnionFind(int A){
            this.parent = new int[A];
            this.rank = new int[A];
            for(int i=0; i<A; i++){
                this.parent[i] = i;
                this.rank[i] = 1;
            }
        }

        public void union(int x, int y){
            int px = find(x);
            int py = find(y);

            if(px == py) return;

            if(this.rank[px] >= this.rank[py]){
                this.parent[py] = px;
                this.rank[px] += this.rank[py];
            }
            else{
                this.parent[px] = py;
                this.rank[py] += this.rank[px];
            }
        }

        public int find(int x){
            if(this.parent[x] != x) this.parent[x] = find(this.parent[x]);
            return this.parent[x];
        }

    }

    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n+1);
        for(int[] edge: edges) {
            uf.union(edge[0], edge[1]);
        }
        
        Set<Integer> cntOfDistinctConnComp = new HashSet();
        for(int i = 0; i < n; i++) {
            cntOfDistinctConnComp.add(uf.find(i));
        }
        
        return cntOfDistinctConnComp.size();
    }
}
