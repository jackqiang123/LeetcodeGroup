// Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
//
// A region is captured by flipping all 'O's into 'X's in that surrounded region.
//
// For example,
//
// X X X X
// X O O X
// X X O X
// X O X X
//
// After running your function, the board should be:
//
// X X X X
// X X X X
// X X X X
// X O X X
public class Solution {
    public void solve(char[][] board) {
      int h = board.length;
      if (h == 0) return;
      int w = board[0].length;
      for (int i = 0; i < h; i++){
          if(board[i][0] == 'O')
            bfs(board, i, 0);
          if (board[i][w-1] == 'O')
            bfs(board, i, w - 1);
      }
      for (int j = 0; j < w; j++){
        if (board[0][j] == 'O')
            bfs(board, 0, j);
        if (board[h-1][j] == 'O')
            bfs(board, h - 1, j);
      }
      for (int i = 0; i < h; i++){
        for (int j = 0; j < w; j++){
          if (board[i][j] == '.')
            board[i][j] = 'O';
          else if (board[i][j] == 'O')
            board[i][j] = 'X';
        }
      }
    }

    private void bfs(char [][]board, int i, int j){
      if (board[i][j] != 'O') return;
      int h = board.length; int w = board[0].length;
      Stack<Cell> queue = new Stack();
      queue.add(new Cell(i, j));
      while(!queue.isEmpty()){
        Cell c = queue.pop();
        board[c.x][c.y] = '.';
        if (c.x - 1 >= 0 && board[c.x - 1][c.y] == 'O'){
          queue.push(new Cell(c.x - 1, c.y));
        }
        if (c.x + 1 < h && board[c.x + 1][c.y] == 'O'){
          queue.push(new Cell(c.x + 1, c.y));
        }
        if (c.y - 1 >= 0 && board[c.x][c.y - 1] == 'O'){
          queue.push(new Cell(c.x, c.y - 1));
        }
        if (c.y + 1 < w && board[c.x][c.y + 1] == 'O'){
          queue.push(new Cell(c.x, c.y + 1));
        }
      }
    }

    class Cell{
      int x;
      int y;
      public Cell(int x, int y){
        this.x = x;
        this.y = y;
      }
    }
}
