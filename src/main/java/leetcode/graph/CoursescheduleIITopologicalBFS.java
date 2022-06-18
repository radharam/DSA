
/*
    https://leetcode.com/problems/course-schedule-ii/
    210. Course Schedule II
  
    TC: O(N)
*/

class CoursescheduleIITopologicalBFS {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList();
        int[] courseIndegree = new int[numCourses];
        buildGraph(adjList, numCourses, prerequisites, courseIndegree);
        Queue<Integer> q = new LinkedList();
        List<Integer> courseOrder = new ArrayList();
        for(int i = 0; i < numCourses; i++){
            if(courseIndegree[i] == 0) q.offer(i);
        }// TC: O(N)
        
        while(!q.isEmpty()) {
            int curr = q.poll();
            courseOrder.add(curr);
            
            for(int course: adjList.get(curr)) {
                courseIndegree[course]--;
                if(courseIndegree[course] == 0) q.offer(course);
            }  
        } // TC: O(N)
        
        for(int degree: courseIndegree) {
            if(degree != 0) return new int[]{};
        }// TC: O(N)
        
        return courseOrder.stream().mapToInt(i -> i).toArray();
    }
    
    public void buildGraph(List<List<Integer>> adjList, int n, int[][] prereq, int[] courseIndegree) {
        for(int i = 0; i < n; i++) {
            adjList.add(new ArrayList<Integer>());
        }// TC: O(N)
        
        for(int[] pre: prereq) {
            adjList.get(pre[1]).add(pre[0]);
            courseIndegree[pre[0]]++;
        } // TC: O(N)
    }
}
