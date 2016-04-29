// Write a program to solve a Sudoku puzzle by filling the empty cells.
//
// Empty cells are indicated by the character '.'.
//
// You may assume that there will be only one unique solution.

public class Solution {
    char [][] backup;
    List<Set<Character>> rowList = new ArrayList<Set<Character>>();
    List<Set<Character>> colList = new ArrayList<Set<Character>>();
    List<Set<Character>> boxList = new ArrayList<Set<Character>>();
    public void solveSudoku(char[][] board) {
      backup = new char[9][9];
      for (int i = 0; i < 9; i++)
      {
        for (int j = 0; j < 9; j++)
        {
          char c = board[i][j];
          rowList.get(i/3).add(c);
          colList.get(j/3).add(c);
          boxList.get(i/3*3 + j/3).add(c);
        }
      }
      dfs(board, 0);
      for (int i = 0; i < 9; i++){
        for (int j = 0; j < 9; j++)
          board[i][j] = backup[i][j];
      }
    }
    private void dfs(char[][] board, int start){
      if (start == 81) {
        for (int i = 0; i < 9; i++)
          for (int j = 0; j < 9; j++)
            backup[i][j] = board[i][j];
      }
      int x = start/9;
      int y = start%9;
      if (board[x][y] != '.') {
        dfs(board, start+1);
      }
      else {
        for (char c = '1'; c < '9'; c++)
        {
          if (!checkValid(board, x, y, c)) continue;
          rowList.get(i/3).add(c);
          colList.get(j/3).add(c);
          boxList.get(i/3*3 + j/3).add(c);
          board[x][y] = c;
          dfs(board, start + 1);
          board[x][y] = '.';
          rowList.get(i/3).remove(c);
          colList.get(j/3).remove(c);
          boxList.get(i/3*3 + j/3).remove(c);
        }
      }
    }

    private boolean checkValid(char[][]board, int i, int j, char c){
      if (rowList.get(i/3).contains(c) || colList.get(j/3).contains(c) || boxList.get(i/3*3 + j/3).contains(c))
        return false;
      return true;
    }
}
