// Walls and Gates
//
// You are given a m x n 2D grid initialized with these three possible values.
//
//     -1 - A wall or an obstacle.
//     0 - A gate.
//     INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the
//  distance to a gate is less than 2147483647.
//
// Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
//
// For example, given the 2D grid:
//
// INF  -1  0  INF
// INF INF INF  -1
// INF  -1 INF  -1
//   0  -1 INF INF
//
// After running your function, the 2D grid should be:
//
//   3  -1   0   1
//   2   2   1  -1
//   1  -1   2  -1
//   0  -1   3   4
public class Solution {
    int h;
    int w;
    boolean [][]visit;
    public void wallsAndGates(int[][] rooms) {
      h = rooms.length;
      w = rooms[0].length;
      for (int i = 0; i < h; i++){
          for (int j = 0; j < w; j++){
            if (rooms[i][j] == 0)
            {
              visit = new boolean[h][w];
              dfs(rooms, i, j, 0);
            }
          }
      }
    }

    private void dfs(int [][]rooms, int i, int j, int dis){
        if (i < 0 || i >= h || j < 0 || j >= w || rooms[i][j] == -1 || !visit[i][j])
          return;
        int newDis = dis + 1;
        visit[i][j] = true;
        if (rooms[i][j] >= newDis){
            rooms[i][j] = newDis;
            dfs(rooms, i-1, j, rooms[i][j]);
            dfs(rooms, i+1, j, rooms[i][j]);
            dfs(rooms, i, j-1, rooms[i][j]);
            dfs(rooms, i, j+1, rooms[i][j]);
        }
    }
}
