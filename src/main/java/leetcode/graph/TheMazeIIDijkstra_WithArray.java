/*
  https://leetcode.com/problems/the-maze-ii/
  505. The Maze II
  
  check for shortest distance
  
  TC: O(NNM * LogNM) SC: O(NM)
*/

//Implemented using array
public class TheMazeIIDijkstra_WithArray {
    public int solve(int[][] A, int[] B, int[] C) {

        return computeshortestDistInMaze(A, B, C);
    }

    public int computeshortestDistInMaze(int[][] A, int[] source, int[] dest) {
        int rowLen = A.length, colLen = A[0].length;
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int[][] distance = new int[rowLen][colLen]; // Distance Matrix
        for(int[] dist: distance) {
            Arrays.fill(dist, Integer.MAX_VALUE); // initialize distance matrix with POS-INF
        }
        distance[source[0]][source[1]] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return o1[2] - o2[2];
        });
        pq.offer(new int[] {source[0], source[1], distance[source[0]][source[1]]});

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            
            if(curr[0] == dest[0] && curr[1] == dest[1]) return curr[2];

            for(int[] dir: dirs) {
                int dx = curr[0] + dir[0], dy = curr[1] + dir[1];
                int count = 0;
                while(dx >= 0 && dx < A.length && dy >= 0 && dy < A[0].length && A[dx][dy] == 0) { 
                    dx += dir[0]; dy += dir[1];
                    count++;
                } 

                if(distance[curr[0]][curr[1]] + count < distance[dx - dir[0]][dy - dir[1]]) {
                    distance[dx - dir[0]][dy - dir[1]] = distance[curr[0]][curr[1]] + count;
                    pq.offer(new int[] {dx-dir[0], dy-dir[1], distance[dx-dir[0]][dy - dir[1]]});
                }
            }
        }

        return distance[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1 : distance[dest[0]][dest[1]];
    }

}
