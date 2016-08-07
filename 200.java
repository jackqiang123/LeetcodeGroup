// Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
//
// Example 1:
//
// 11110
// 11010
// 11000
// 00000
// Answer: 1
//
// Example 2:
//
// 11000
// 11000
// 00100
// 00011
// Answer: 3
public class Solution {
    int h;
    int w;
    boolean[][]visit;
    public int numIslands(char[][] grid) {
      h = grid.length;
      if (h == 0) return 0;
      w = grid[0].length;
      visit = new boolean[h][w];
      int res = 0;
      for (int i = 0; i < h; i++){
        for (int j = 0; j < w; j++){
          if (!visit[i][j] &&  grid[i][j] == '1') {
            res++; dfs(grid, i, j);
          }
        }
      }
      return res;
    }
    private void dfs(char[][]grid, int i, int j){
      if (i < 0 || i >= h || j < 0 || j >= w || visit[i][j] || grid[i][j] == '0') return;
      int []dx = {0, 1, 0, -1};
      int []dy = {1, 0, -1, 0};
      visit[i][j] = true;
      for (int k = 0; k < dx.length; k++)
        dfs(grid, i + dx[k], j + dy[k]);
    }
}
