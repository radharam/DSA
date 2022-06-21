    /*
        https://leetcode.com/problems/walls-and-gates/
        286. Walls and Gates
        Approach is to go from gate to empty rooms, to calculate distance to gate rooms backwards

        TC: O(NM) SC: O(NM)

    */

    public class WallsAndGatesBFS {
        final int GATE = 0;
        final int EMPTY = Integer.MAX_VALUE;
        public void wallsAndGates(int[][] rooms) {
            int rowLen = rooms.length, colLen = rooms[0].length;
            int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

            Queue<int[]> q = new LinkedList<>();
            for(int r = 0; r < rowLen; r++) {
                for(int c = 0; c < colLen; c++) {
                    if(rooms[r][c] == this.GATE) {
                        q.offer(new int[] {r, c});
                    }
                }
            }

            while(!q.isEmpty()) {
                int[] curr = q.poll();

                for(int[] dir: dirs){
                    int dx = curr[0] + dir[0], dy = curr[1] + dir[1];

                    if(dx < 0 || dx >= rowLen || dy < 0 || dy >= colLen || rooms[dx][dy] != this.EMPTY) continue;

                    rooms[dx][dy] = rooms[curr[0]][curr[1]] + 1;
                    q.offer(new int[]{dx, dy});
                }

            }
        }
    }
