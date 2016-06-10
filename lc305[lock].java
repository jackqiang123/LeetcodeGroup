// roblem Description:
//
// A 2d grid map of m rows and n columns is initially filled with water.
// We may perform an addLand operation which turns the water at position (row, col) into a land.
// Given a list of positions to operate, count the number of islands after each addLand operation.
// An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
// You may assume all four edges of the grid are all surrounded by water.
//
// Example:
//
// Given m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]].
// Initially, the 2d grid grid is filled with water. (Assume 0 represents water and 1 represents land).
//
// 0 0 0
// 0 0 0
// 0 0 0
//
// Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.
//
// 1 0 0
// 0 0 0   Number of islands = 1
// 0 0 0
//
// Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land.
//
// 1 1 0
// 0 0 0   Number of islands = 1
// 0 0 0
//
// Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land.
//
// 1 1 0
// 0 0 1   Number of islands = 2
// 0 0 0
//
// Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land.
//
// 1 1 0
// 0 0 1   Number of islands = 3
// 0 1 0
//
// We return the result as an array: [1, 1, 2, 3]
public class Solution{
  class UnionPoint{
      UnionPoint root;
      public UnionPoint(){
        root = this;
      }

      public boolean union(UnionPoint that){
        if (that == null) return false;
        UnionPoint root = that.root();
        if (root == this) return false; // they already connected
        root.parent = this;
        return true;
      }

      public UnionPoint root(){
        UnionPoint point = this;
        while(point.parent != point)
          point = point.parent;
        return point;
      }

  }

  public List<Integer> numIslands2(int m, int n, int[][] positions) {
    UnionPoint[][] data = new UnionPoint[m][n];
    List<Integer> res = new ArrayList<Integer>();
    int count = 0;
    for (int i = 0; i < positions.length; i++){
      int x = positions[i][0];
      int y = positions[i][1];
      if (data[x][y] == null){
        data[x][y] = new UnionPoint();
        int N = 0;
        if (x-1 >= 0)
          if (data[x][y].union(data[x-1][y]))
            N++;
        if (x+1 < m)
          if (data[x][y].union(data[x+1][y]))
            N++;
        if (y-1 >= 0)
          if (data[x][y].union(data[x][y-1]))
            N++;
        if (y+1 < n)
          if (data[x][y].union(data[x][y+1]))
            N++;
        if (N == 0) count++;//none is successful connect
        else if (N >= 2) count += (N-1);
      }
      res.add(count);
    }
    return res;
  }
}

// a 2d only Solutionpublic class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        boolean[][] map = new boolean[m][n];
        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        List<Integer> list = new ArrayList<Integer>();
        int island = 0;
        int[] fa = new int[m * n];

        //initialization
        for (int i = 0; i < m * n; i++) {
            fa[i] = i;
        }

        for (int i = 0; i < positions.length; i++) {
            island++;
            map[positions[i][0]][positions[i][1]] = true;
            int x, y;
            int f = positions[i][0] * n + positions[i][1];
            for (int k = 0; k < 4; k++) {
                x = positions[i][0] + dir[k][0];
                y = positions[i][1] + dir[k][1];
                if (x >= 0 && x < m && y >=0 && y < n && map[x][y] && getfather(fa, x * n + y) != f) {
                    fa[getfather(fa, x * n + y)] = f;
                    island--;
                }
            }
            list.add(island);
        }
        return list;
    }

    //disjoint-set and path compression
    public int getfather(int[] fa, int i) {
        if (fa[i] == i) {
            return i;
        }
        fa[i] = getfather(fa, fa[i]);//path compression here
        return fa[i];
    }
}
