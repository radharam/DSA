/* 
https://leetcode.com/problems/the-maze/
490. The Maze

check if there is a path from source to destination with DFS approach

*/

class Solution {
    // DFS Aproach
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        return dfs(maze, start, destination, visited);
    }
    
    public boolean dfs(int[][] maze, int[] start, int[] destination, boolean[][] visited) {
        // Base condition
        
        // if visited, don't explore further
        if(visited[start[0]][start[1]]) return false;
        // check if reached destination
        if(start[0] == destination[0] && start[1] == destination[1]) return true;
        
        // Main Logic
        // mark visited
        visited[start[0]][start[1]] = true;
        
        // directions
        int u = start[0] - 1, r = start[1] + 1, d = start[0] + 1, l = start[1] - 1;
        
        // move up
        while(u >= 0 && maze[u][start[1]] == 0) u--;
        if(dfs(maze, new int[] {u+1, start[1]}, destination, visited)) return true;
        
        // move right
        while(r < maze[0].length && maze[start[0]][r] == 0) r++;
        if(dfs(maze, new int[] {start[0], r-1}, destination, visited)) return true;
        
        // move down
        while(d < maze.length && maze[d][start[1]] == 0) d++;
        if(dfs(maze, new int[] {d-1, start[1]}, destination, visited)) return true;
        
        // move left
        while(l >= 0 && maze[start[0]][l] == 0) l--;
        if(dfs(maze, new int[] {start[0],l+1}, destination, visited)) return true;
        
        return false;
        
    }
}
