package src.main.java.leetcode.graph.dfs;

import java.util.ArrayList;
import java.util.List;

class PacificAtlanticOceanDFS {
    int rowLen = 0, colLen = 0;
    int[][] landHeights; // global reference to land heights
    int[][] dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 4 directions
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        
        return pacificAtlanticFlowBFS(heights);
    }
    
    public List<List<Integer>> pacificAtlanticFlowBFS(int[][] heights) {
        rowLen = heights.length; colLen = heights[0].length;
        
        // visited indexes
        boolean[][] v_atl = new boolean[rowLen][colLen], v_pac = new boolean[rowLen][colLen];
        landHeights = heights;
        
        //travese first n last row
        for(int c = 0; c < colLen; c++) {
            dfs(0, c, v_atl, heights[0][c]); 
            dfs(rowLen-1, c, v_pac, heights[rowLen-1][c]);
        }
        
        //travese first n last col
        for(int r = 0; r < rowLen; r++) {
            dfs(r, 0, v_atl, heights[r][0]);
            dfs(r, colLen-1, v_pac, heights[r][colLen-1]);
        }
        
        // check visited indexes for pacific n atlantic n add to res
        List<List<Integer>> result = new ArrayList<>();
        for(int r = 0; r < rowLen; r++) {
            for(int c = 0; c < colLen; c++) {
                if(v_atl[r][c] && v_pac[r][c]) {
                    List<Integer> visitedList = new ArrayList<>();
                    visitedList.add(r);
                    visitedList.add(c);
                    result.add(visitedList);
                }
            }  
        }
        
        return result;
    }
    
    // dfs search of all indexes
    public void dfs(int row, int col, boolean[][] visited, int prevHeight) {
        if(row < 0 || col < 0 || row == rowLen || col == colLen || visited[row][col] || landHeights[row][col] < prevHeight) return;
        
        visited[row][col] = true;
        
        for(int[] dir: dirs) {
            int dr = row + dir[0], dc = col + dir[1];
            dfs(dr, dc, visited, landHeights[row][col]);
        }
    }
}
