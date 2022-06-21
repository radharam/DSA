/*
    https://leetcode.com/problems/surrounded-regions
    
    130. Surrounded Regions
    
    Approach add all border cells to a list
    visit each border cell if O visit it an all its adjacent cells n change from O to say E
    
    onnce done traverse array n mark all Os as X which is island, not touching border n change all Es to O
    
    TC:(NM) - since in worst case entire matrix is land, n you visit it only once
    SC:(NM)

*/

public class SurroundedRegionsBFS {
    public void solve(char[][] board) {
        
        List<Pair<Integer, Integer>> borders = new LinkedList<>();
        int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        // 1. Construct list of border cells
        // visit col border
        for(int r = 0; r < board.length; r++) {
            borders.add(new Pair(r, 0)); // first col
            borders.add(new Pair(r, board[0].length-1)); // last col
        }//TC: O(N)
        
        // visit row border
        for(int c = 0; c < board[0].length; c++) {
            borders.add(new Pair(0, c)); // first row 
            borders.add(new Pair(board.length-1, c)); // last row
        } //TC: O(M)
        
        // 2. Mark if cells(land) that is adjoining the border
        for(Pair<Integer, Integer> borderLand : borders) {
            this.markBorderingLand(board, borderLand, dirs);
        } //TC: O(NM)
        
        // 3. mark island cells as 'X' n border cells as 'O'
        for(int r = 0; r < board.length; r++) {
            for(int c = 0; c < board[0].length; c++) {
                if(board[r][c] == 'O') board[r][c] = 'X';
                if(board[r][c] == 'E') board[r][c] = 'O';
            }
        } // TC: O(NM)
        
    }
    
    public void markBorderingLand(char[][] board, Pair<Integer, Integer> border, int[][] dirs) {
        
        Queue<Pair> q = new LinkedList<>();
        q.offer(border);
        while(!q.isEmpty()) {
            Pair<Integer, Integer> curr = q.poll();
            if(board[curr.first][curr.second] != 'O') continue;
            
            board[curr.first][curr.second] = 'E';
            for(int[] dir: dirs) {
                int dx = curr.first + dir[0], dy = curr.second + dir[1];
                if(dx >= 0 && dx < board.length && dy >= 0 && dy < board[0].length) {
                    q.offer(new Pair(dx, dy));
                }
            }
            
        }
    } // TC: O(NM)
    
    
    class Pair<U, V> {
        public U first;
        public V second;
        
        public Pair(U first, V second) {
            this.first = first;
            this.second = second;
        }
    }
}
