package src.main.java.leetcode.graph.dfs;/*
    https://leetcode.com/problems/course-schedule/
    207. Course Schedule

*/


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] courceIndegree = new int[numCourses];
        List<List<Integer>> adjList = new ArrayList<>();
        buildGraph(adjList, numCourses, prerequisites, courceIndegree);           
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < numCourses; i++) {
            if(courceIndegree[i] == 0) q.offer(i);
        }
        
        while(!q.isEmpty()) {
            int curr = q.poll();
            
            for(int neighbour: adjList.get(curr)) {
                courceIndegree[neighbour]--;
                if(courceIndegree[neighbour] == 0)                                                      q.offer(neighbour);
            }
        }
        
        for(int c: courceIndegree) {
            if(c > 0) return false;
        }
        
        
        return true;
    }
                           
    public void buildGraph(List<List<Integer>> adjList, int n, int[][] prereq, int[] courceIndegree) {
        for(int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        
        for(int[] pre: prereq) {
            adjList.get(pre[1]).add(pre[0]);
            courceIndegree[pre[0]]++;
        }
    }
    
    
}
