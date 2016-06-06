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
      for (int i = 0; i < 9; i++){
          rowList.add(new HashSet());
          colList.add(new HashSet());
          boxList.add(new HashSet());
      }
      for (int i = 0; i < 9; i++)
      {
        for (int j = 0; j < 9; j++)
        {
          char c = board[i][j];
          rowList.get(i).add(c);
          colList.get(j).add(c);
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
        return;
      }
      int x = start/9;
      int y = start%9;
      if (board[x][y] != '.') {
        dfs(board, start+1);
      }
      else {
        for (char c = '1'; c <= '9'; c++)
        {
          if (!checkValid(board, x, y, c)) continue;
          rowList.get(x).add(c);
          colList.get(y).add(c);
          boxList.get(x/3*3 + y/3).add(c);
          board[x][y] = c;
          dfs(board, start + 1);
          board[x][y] = '.';
          rowList.get(x).remove(c);
          colList.get(y).remove(c);
          boxList.get(x/3*3 + y/3).remove(c);
        }
      }
    }

    private boolean checkValid(char[][]board, int i, int j, char c){
      if (rowList.get(i).contains(c) || colList.get(j).contains(c) || boxList.get(i/3*3 + j/3).contains(c))
        return false;
      return true;
    }
}
