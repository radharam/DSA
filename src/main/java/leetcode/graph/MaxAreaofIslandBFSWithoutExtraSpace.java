package src.main.java.leetcode.graph;/*
    https://leetcode.com/problems/max-area-of-island/
    695. Max Area of Island
    
    TC: O(N^2 * M^2)
    SC: O(1)
*/


import java.util.LinkedList;
import java.util.Queue;

public class MaxAreaofIslandBFSWithoutExtraSpace {

    // boolean[][] visited;
    public int maxAreaOfIsland(int[][] grid) {
        // base case if grid size is 1
        if (grid.length == 1 && grid[0].length == 1) {
            return grid[0][0] == 1 ? 1 : 0; // if land 1, else 0
        }

        int maxArea = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                maxArea = Math.max(maxArea, computeAreaBFSWithoutExtraSpace(grid, r, c));
            }
        }

        return maxArea;
    }

    public int computeAreaBFSWithoutExtraSpace(int[][] grid, int r, int c) {
        // base case if cell is water
        if (grid[r][c] == 0) return 0;

        int[][] dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        Queue<int[]> q = new LinkedList();
        q.offer(new int[]{r, c});
        grid[r][c] = 0; // set value of cell to 0, as its visited
        int area = 1; // initialize area to 1, to count first cell
        while (!q.isEmpty()) {
            int[] curr = q.poll();

            for (int[] dir : dirs) {
                int dx = curr[0] + dir[0], dy = curr[1] + dir[1];
                // if out of bounnds continue
                if (dx < 0 || dx >= grid.length || dy < 0 || dy >= grid[0].length) continue;

                if (grid[dx][dy] == 1) {  // if land
                    area++; // incr area
                    grid[dx][dy] = 0; // set to 0, to not visit again
                    q.offer(new int[]{dx, dy}); // add to queue to visit its adjacent islands
                }

            }
        }

        return area;
    }
}
