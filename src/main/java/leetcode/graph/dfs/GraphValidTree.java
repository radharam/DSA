package src.main.java.leetcode.graph.dfs;/*
https://leetcode.com/problems/graph-valid-tree/

261. Graph Valid Tree

Checks for cycle, nn if all nodes are connnected

*/

import java.util.*;

class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        
        return checkValidTreeBFS(n, edges);
    }
    
    // BFS approach to check for validity of Graph tree
    public boolean checkValidTreeBFS(int n, int[][] edges) {
        // no of edges is more than or less than no of edges, then not valid
        if(edges.length != n-1) return false;
        
        List<List<Integer>> adjList = new ArrayList<>();
        buildGraph(adjList, n, edges); // build graph
        
        // set to mark visited edges
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        visited.add(0);
        
        while(!q.isEmpty()) {
            int curr = q.poll();
            
            for(int neighbour: adjList.get(curr)) {
                if(visited.contains(neighbour)) continue;
                visited.add(neighbour);
                q.offer(neighbour);
            }
        }
        // if set size equals no of nodes then valid
        return visited.size() == n;
    }
    
    public void buildGraph(List<List<Integer>> adjList, int n, int[][] edges) {
       for(int i = 0; i < n; i++) {
           adjList.add(new ArrayList<>());
       } 
        
        for(int[] edge: edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
    }
    
   
}
