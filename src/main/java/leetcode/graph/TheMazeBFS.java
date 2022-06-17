
/*
  https://leetcode.com/problems/the-maze/submissions/
  490. The Maze
*/
class TheMazeBFS {
    public boolean hasPath(int[][] maze, int[] start, int[] dest) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        visited[start[0]][start[1]] = true;
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            
            // check if dest is reached
            if(curr[0] == dest[0] && curr[1] == dest[1]) return true;
            
            // else explore all four directions
            for(int[] dir: dirs) {
                int dx = curr[0] + dir[0], dy = curr[1] + dir[1];
                // keep exporing till x or y is outofbounds or x, y hits a wall
                while(dx >= 0 && dx < maze.length && dy >= 0 && dy < maze[0].length && maze[dx][dy] == 0) {
                    dx += dir[0]; dy += dir[1];
                }
                
                // step back when condition fails n mark that cell as visited, nn add to queue
                if(!visited[dx-dir[0]][dy-dir[1]]) {
                    q.offer(new int[]{dx - dir[0], dy - dir[1]});
                    visited[dx-dir[0]][dy-dir[1]] = true;
                }
            }
        }
        
        return false;
    }
}
