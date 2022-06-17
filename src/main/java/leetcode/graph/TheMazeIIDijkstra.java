/*
  https://leetcode.com/problems/the-maze-ii/
  505. The Maze II
  
  check for shortest distance
  
  TC: O(NNM * LogNM) SC: O(NM)

*/

public class TheMazeIIDijkstra {
    public int shortestDistance(int[][] maze, int[] start, int[] dest) {
        int[][] distance = new int[maze.length][maze[0].length];
        for(int[] dist: distance) {
            Arrays.fill(dist, Integer.MAX_VALUE);
        }
        distance[start[0]][start[1]] = 0;
        dijkstra(maze, start, distance);
        
        return distance[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1 : distance[dest[0]][dest[1]];
        
    }
    
    public void dijkstra(int[][] maze, int[] start, int[][] distance) {
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        
        // order by distance
        PriorityQueue<Pair> pq = new PriorityQueue<>( (o1, o2) -> {
            return o1.d - o2.d;
        });
        pq.offer(new Pair(start[0], start[1], distance[start[0]][start[1]]));
        while(!pq.isEmpty()) {
            Pair curr = pq.poll();
            
            if(curr.d > distance[curr.x][curr.y]) continue;
            
            for(int[] dir: dirs) {
                int dx = curr.x + dir[0], dy = curr.y + dir[1];
                int count = 0;
                while(dx >= 0 && dx < maze.length && dy >= 0 && dy < maze[0].length && maze[dx][dy] == 0) {
                    dx += dir[0]; dy += dir[1];
                    count++;
                }
                
                if(distance[curr.x][curr.y] + count < distance[dx - dir[0]][dy - dir[1]]) {
                distance[dx - dir[0]][dy - dir[1]] = distance[curr.x][curr.y] + count;
                pq.offer(new Pair(dx - dir[0], dy - dir[1], distance[dx - dir[0]][dy - dir[1]]));
                }
            }
        }
        
    }
    
    class Pair {
        int x, y, d;
        public Pair(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
}
