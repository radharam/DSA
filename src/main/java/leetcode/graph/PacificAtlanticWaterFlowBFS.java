
/*
        https://leetcode.com/problems/pacific-atlantic-water-flow/
        417. Pacific Atlantic Water Flow

*/


public class PacificAtlanticWaterFlowBFS {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length, m = heights[0].length;
        int[][] dp = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0; i<m; i++){
            visited[0][i] = true;
            queue.offer(new int[]{0, i});
            dp[0][i] += 1;
        }
        for(int i=1; i<n; i++){
            visited[i][0] = true;
            queue.offer(new int[]{i, 0});
            dp[i][0] += 1;
        }
        bfs(heights, visited, queue, dp);
        visited = new boolean[n][m];
        queue = new LinkedList<>();
        
        for(int i=0; i<m; i++){
            visited[n-1][i] = true;
            queue.offer(new int[]{n-1, i});
            dp[n-1][i] += 1;
        }
        for(int i=0; i<n-1; i++){
            visited[i][m-1] = true;
            queue.offer(new int[]{i, m-1});
            dp[i][m-1] += 1;
        }
        bfs(heights, visited, queue, dp);
        
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(dp[i][j] == 2) ans.add(Arrays.asList(i, j));
            }
        }
        return ans;
        
    }
    
    public void bfs(int[][] heights, boolean[][] visited, Queue<int[]> queue, int[][] dp){
        int n = heights.length, m = heights[0].length;
        int[][] dirs = {{0, 1},{0, -1},{1, 0},{-1, 0}};
        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for(int[] dir : dirs){
                int dx = x + dir[0], dy = y + dir[1];
                
                if(dx < 0 || n <= dx || dy < 0 || m <= dy) continue;
                if(visited[dx][dy]) continue;
                if(heights[dx][dy] < heights[x][y]) continue;
                visited[dx][dy] = true;
                dp[dx][dy] += 1;
                queue.offer(new int[]{dx, dy});
            }
        }
    }
}
