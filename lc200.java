// Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
// An island is surrounded by water and is formed by connecting adjacent lands
// horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
//
// Example 1:
//
// 11110
// 11010
// 11000
// 00000
//
// Answer: 1
//
// Example 2:
//
// 11000
// 11000
// 00100
// 00011
//
// Answer: 3
//
// Credits:
// Special thanks to @mithmatt for adding this problem and creating all test cases.
//
// Subscribe to see which companies asked this question

public class Solution {
    boolean [][]visit;
    int res;
    public int numIslands(char[][] grid) {
      res = 0;
      int h = grid.length;
      int w = grid[0].length;
      visit = new int[h][w];
      for (int i = 0; i < h; i++){
        for (int j = 0; j < w; j++)
          dfs(grid, i, j);
      }
    }
}
