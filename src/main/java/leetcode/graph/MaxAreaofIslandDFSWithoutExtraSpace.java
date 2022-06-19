
/*
    https://leetcode.com/problems/max-area-of-island/
    695. Max Area of Island
    
    TC: O(N^2 * M^2)
    SC: O(NM)
*/

public class MaxAreaofIslandDFSWithoutExtraSpace {
    public int maxAreaOfIsland(int[][] grid) {
       //visited = new boolean[grid.length][grid[0].length];
        int maxArea = 0;
        for(int r = 0; r < grid.length; r++) {
            for(int c = 0; c < grid[0].length; c++) {
                maxArea = Math.max(maxArea, computeAreaDFSWithoutExtraSpace(grid, r, c));
            }
        }
        
        return maxArea;
    }
    
    public int computeAreaDFSWithoutExtraSpace(int[][] grid, int r, int c) {
        
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0) return 0;
        
        grid[r][c] = 0;
        return (1 + computeAreaDFSWithExtraSpace(grid, r-1, c) +
                    computeAreaDFSWithExtraSpace(grid, r+1, c) +
                    computeAreaDFSWithExtraSpace(grid, r, c-1) +
                    computeAreaDFSWithExtraSpace(grid, r, c+1));
    }
}
