/*
  https://leetcode.com/problems/the-maze-ii/
  505. The Maze II
  
  check for shortest distance
  
  TC: O(MN*max(N,M)) SC: O(NM)
*/



class TheMazeIIBFS {
    public int shortestDistance(int[][] maze, int[] start, int[] dest) {
        int rowLen = maze.length, colLen = maze[0].length;
        int[][] distance = new int[rowLen][colLen];
        for(int[] dist: distance) {
            Arrays.fill(dist, Integer.MAX_VALUE);
        }
        
        distance[start[0]][start[1]] = 0;
        int[][] dirs = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            
            for(int[] dir: dirs) {
                int dx = curr[0] + dir[0], dy = curr[1] + dir[1];
                int count = 0;
                while(dx >= 0 && dx < maze.length && dy >= 0 && dy < maze[0].length && maze[dx][dy] == 0) {
                    dx += dir[0]; dy += dir[1];
                    count++;
                }
                
                if(distance[curr[0]][curr[1]] + count < distance[dx - dir[0]][dy - dir[1]]) {
                    distance[dx - dir[0]][dy - dir[1]] = distance[curr[0]][curr[1]] + count;
                    q.offer(new int[] {dx-dir[0], dy-dir[1]});
                }
            }
        }
        
        return distance[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1 : distance[dest[0]][dest[1]];
    }
}
