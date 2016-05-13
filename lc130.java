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
      int w = board[0].lenght;
      for (int i = 0; i < h; i++){
        for (int j = 0; j < w; j++)
        {
          if (i == 0 || j == 0)
            dfs(board, i, j);
        }
      }
      for (int i = 0; i < h; i++){
        for (int j = 0; j < w; j++){
          if (board[i][j] == '。')
            board[i][j] = 'O';
          else if (board[i][j] == 'X')
            board[i][j] = 'X';
        }
      }
    }

    private void dfs(char [][]board, int i, int j){
      if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O')
        return;
      else {
        board[i][j] = '.';
        dfs(board, i - 1, j);
        dfs(board, i + 1, j);
        dfs(board, i, j - 1);
        dfs(board, i, j + 1);
        }
    }
}
