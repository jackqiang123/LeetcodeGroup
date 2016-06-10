// You want to build a house on an empty land which reaches all buildings in the shortest amount of distance. You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:
//
// Each 0 marks an empty land which you can pass by freely.
// Each 1 marks a building which you cannot pass through.
// Each 2 marks an obstacle which you cannot pass through.
// For example, given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2):
//
// 1 - 0 - 2 - 0 - 1
// |   |   |   |   |
// 0 - 0 - 0 - 0 - 0
// |   |   |   |   |
// 0 - 0 - 1 - 0 - 0
// The point (1,2) is an ideal empty land to build a house, as the total travel distance of 3+3+1=7 is minimal. So return 7.
//
// Note:
// There will be at least one building. If it is not possible to build such house according to the above rules, return -1.
public class Solution{
  public int shortestDistance(int[][] grid) {
    int h = grid.length;
    int w = grid[0].length;
    int [][]dis = new int[h][w];
    for (int i = 0; i < h; i++){
      for (int j = 0; j < w; j++){
        if (grid[i][j] == 1){// this is a building
            Queue<Integer> queue = new LinkedList();
            queue.add(i*w+j);
            int level = 0;
            boolean [][]visit = new boolean[h][w];
            while(!queue.isEmpty()){
              int count = queue.size();
              for (int k = 0; k < count; k++){
                int cur = queue.remove();
                int x = cur/w;
                int y = cur%w;
                dis[x][y] += level;
                if (x - 1 >= 0 && grid[x-1][y] == 0 && !visit[x-1][y]){
                  queue.add((x-1)*w+y);
                  visit[x-1][y] = true;
                }
                if (x + 1 < h && grid[x+1][y] == 0 && !visit[x+1][y]){
                  queue.add((x+1)*w+y);
                  visit[x+1][y] = true;
                }
                if (y - 1 >= 0 && grid[x][y-1] == 0 && !visit[x][y-1]){
                  queue.add(x*w+y-1);
                  visit[x][y-1] = true;
                }
                if (y + 1 < w && grid[x][y + 1] == 0 && !visit[x][y + 1]){
                  queue.add( x*w+y + 1);
                  visit[x][y+1] = true;
                }
              }
              level++;
            }
        }
      }
    }
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < h; i++){
      for (int j = 0; j < w; j++)
      {
        if (grid[i][j] == 0)
          min = Math.min(min, dis[i][j]);
      }
    }
    return min == 0 ? -1:min;
  }
}
