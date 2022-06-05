package src.main.java.leetcode.graph.dfs;
/* Number of islands */

/* Problem Description
Given a matrix of integers A of size N x M consisting of 0 and 1. A group of connected 1's forms an island. From a cell (i, j) such that A[i][j] = 1 you can visit any cell that shares a corner with (i, j) and value in that cell is 1.
More formally, from any cell (i, j) if A[i][j] = 1 you can visit:
(i-1, j) if (i-1, j) is inside the matrix and A[i-1][j] = 1.
(i, j-1) if (i, j-1) is inside the matrix and A[i][j-1] = 1.
(i+1, j) if (i+1, j) is inside the matrix and A[i+1][j] = 1.
(i, j+1) if (i, j+1) is inside the matrix and A[i][j+1] = 1.
(i-1, j-1) if (i-1, j-1) is inside the matrix and A[i-1][j-1] = 1.
(i+1, j+1) if (i+1, j+1) is inside the matrix and A[i+1][j+1] = 1.
(i-1, j+1) if (i-1, j+1) is inside the matrix and A[i-1][j+1] = 1.
(i+1, j-1) if (i+1, j-1) is inside the matrix and A[i+1][j-1] = 1.
Return the number of islands.
NOTE: Rows are numbered from top to bottom and columns are numbered from left to right.
Problem Constraints
1 <= N, M <= 100
0 <= A[i] <= 1
Input Format
The only argument given is the integer matrix A.
Output Format
Return the number of islands.
Example Input
Input 1:
 A = [
       [0, 1, 0]
       [0, 0, 1]
       [1, 0, 0]
     ]
Input 2:
 A = [
       [1, 1, 0, 0, 0]
       [0, 1, 0, 0, 0]
       [1, 0, 0, 1, 1]
       [0, 0, 0, 0, 0]
       [1, 0, 1, 0, 1]
     ]
Example Output
Output 1:
 2
Output 2:
 5
Example Explanation
Explanation 1:
 The 1's at position A[0][1] and A[1][2] forms one island.
 Other is formed by A[2][0].
Explanation 2:
 There 5 island in total. */
public class NumberOfIslands {

    static int[] dx = new int[]{-1, 0, 1, 0, -1, -1, 1, 1};
    static int[] dy = new int[]{0, 1, 0, -1, -1, 1, 1, -1};
    public int solve(int[][] A) {

        return findNumberOfIslands(A);
    }

    public int findNumberOfIslands(int[][] A) {
        int rowLen = A.length, colLen = A[0].length;
        int noOfIslands = 0;

        // iterate matrix to fid counnt of components repr as islands
        for(int r = 0; r < rowLen; r++) {
            for(int c = 0; c < colLen; c++) {
                // check if node is not visted
                if(A[r][c] != 0) {
                    /* for each set of componnents not visted, incr count Island, 
                    and mark all adjoining nodes as visted by DFS approach */
                    noOfIslands++;
                    computeNumberOfIslands(A, r, c);
                }
            }
        }

        return noOfIslands;
    }

    // Normal DFS to visit the cells of the matrix
    public void computeNumberOfIslands(int[][] M, int x, int y) {
        // marking cell as visited
        M[x][y] = 0;

        for(int d = 0; d < 8; d++) {
            // compute new coordinates
            int nx = x + dx[d];
            int ny = y + dy[d];

            // check boundary conndition and cell is not visited
            if(nx >= 0 && ny >= 0 && nx <= M.length-1 && ny <= M[0].length-1 && M[nx][ny] != 0) {
                computeNumberOfIslands(M, nx, ny);
            }
        }
    }
}
