/*
    https://leetcode.com/problems/max-area-of-island/
    695. Max Area of Island
    
    TC: O(N^2 * M^2)
    SC: O(NM)
*/
class MaxAreaofIslandDFSWithExtraSpaceOpt1 {
    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length]; // define once nn reuse
        int[][] dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int maxArea = 0;
        for(int r = 0; r < grid.length; r++) {
            for(int c = 0; c < grid[0].length; c++) {
                //maxArea = Math.max(maxArea, computeAreaDFSWithExtraSpace(grid, r, c, visited));
                maxArea = Math.max(maxArea, computeAreaDFSWithExtraSpace(grid, r, c, visited, dirs));
            }
        }
        
        return maxArea;
    }
    
    public int computeAreaDFSWithExtraSpace(int[][] grid, int r, int c, boolean[][] visited) {
        
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0 || visited[r][c]) return 0;
        
        visited[r][c] = true;
        return (1 + computeAreaDFSWithExtraSpace(grid, r-1, c, visited) +
                    computeAreaDFSWithExtraSpace(grid, r+1, c, visited) +
                    computeAreaDFSWithExtraSpace(grid, r, c-1, visited) +
                    computeAreaDFSWithExtraSpace(grid, r, c+1, visited));
    }
    
    public int computeAreaDFSWithExtraSpaceApproach2(int[][] grid, int r, int c, boolean[][] visited) {
        
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0 || visited[r][c]) return 0;
        
        visited[r][c] = true;
        int area = 1;
        for(int[] dir: dirs) {
            int x = r + dir[0], y = c + dir[1];
            area += computeAreaDFSWithExtraSpace(grid, x, y, visited, dirs);
        }
        
        return area;
    }
    
    // changed dirs as pass in param
    public int computeAreaDFSWithExtraSpaceApproach3(int[][] grid, int r, int c, boolean[][] visited, int[][] dirs) {
        
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0 || visited[r][c]) return 0;
        
        visited[r][c] = true;
        int area = 1;
        for(int[] dir: dirs) {
            int x = r + dir[0], y = c + dir[1];
            area += computeAreaDFSWithExtraSpace(grid, x, y, visited);
        }
        
        return area;
    }
}
