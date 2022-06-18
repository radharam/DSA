
/*
  https://leetcode.com/problems/course-schedule/
  
  207. Course Schedule
  
  TC: O(N + E)
  
*/



class CoursescheduleTopologicalBFS {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList();
        int[] courseIndegree = new int[numCourses]; // maintain inndegree
        buildGraph(adjList, numCourses, prerequisites, courseIndegree); // build adjGraph
        Queue<Integer> q = new LinkedList();
        for(int i = 0; i < numCourses; i++) {
            if(courseIndegree[i] == 0) q.offer(i); // add to queue if indegree is 0
        } // TC: O(N)
        
        // iterate queue
        while(!q.isEmpty()) {
            int curr = q.poll(); // for every val, visit its neigbours
            
            for(int neighbour: adjList.get(curr)) {
                courseIndegree[neighbour]--; // reduce neigbour indegree
                if(courseIndegree[neighbour] == 0) q.offer(neighbour); // add to queue if 0
            }
        } // TC: O(N)
        
        // check if anny val has indegree > 0, if yes return false else true
        for(int degree: courseIndegree) {
            if(degree != 0) return false; 
        } // TC: O(N)
        
        return true;
    } // TC: O(N)
    
    public void buildGraph(List<List<Integer>> adjList, int n, int[][] prereq, int[] courseIndegree) {
        for(int i = 0; i < n; i++) {
            adjList.add(new ArrayList<Integer>());
        } // TC: O(N)
        
        for(int[] pre: prereq) {
            adjList.get(pre[1]).add(pre[0]); // get the list at that index n add values to it
            courseIndegree[pre[0]]++;
        } // TC: O(E)
    }
}
