/*
    https://leetcode.com/problems/rotting-oranges
    994. Rotting Oranges
    
    TC: O(NM)
    SC: O(NM), worst case if entire grid is filled with rotten oranges 
    without visited

*/


class RottingOrangesBFS {
    public int orangesRotting(int[][] grid) {
        return rottingOranges(grid);
    }
    
    public int rottingOranges(int[][] grid) {
        int rowLen = grid.length, colLen = grid[0].length;  
        Queue<Pair<Integer, Integer, Integer>> q = new LinkedList<>();
        int freshOranges = 0, maxTime = 0;
        
        // 1. add rotten oranges to queue, and count no of fresh oranges
        for(int r = 0; r < rowLen; r++) {
            for(int c = 0; c < colLen; c++) {
                if(grid[r][c] == 2) q.offer(new Pair(r, c, 0));
                if(grid[r][c] == 1) freshOranges++;
            }    
        } // TC: O(NM)
        
        int minutes = 0; // starting from 1st level, spreading outward
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        // 2. dequeue rotten oranges, and mark adjoining oranges as rotten
        while(!q.isEmpty()) {
            Pair<Integer, Integer, Integer> curr = q.poll();
            for(int[] dir: dirs) {
                int dx = curr.x + dir[0], dy = curr.y + dir[1];
                
                // 3. check if within bounds, if fresh n not visited
                if(dx >= 0 && dx < grid.length && dy >= 0 && dy < grid[0].length && grid[dx][dy] == 1 ) { 
                    // mark rotten
                    grid[dx][dy] = 2;
                    // decr fresh orange count
                    freshOranges--;
                    // add to queue to visit its adjacent
                    q.offer(new Pair(dx, dy, curr.t + 1));
                }
            }
            
            maxTime = Math.max(maxTime, curr.t);
        }
        
        return freshOranges > 0 ? -1 : maxTime;
    } // TC O(NM)
    
    class Pair<U, V, T> {
        public U x;
        public V y;
        public T t;
        
        public Pair(U x, V y, T t) {
            this.x = x;
            this.y = y;
            this.t = t;
        }
    }
}
