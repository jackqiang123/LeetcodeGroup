// Given a 2D board and a word, find if the word exists in the grid.
//
// The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
//
// For example,
// Given board =
//
// [
//   ['A','B','C','E'],
//   ['S','F','C','S'],
//   ['A','D','E','E']
// ]
// word = "ABCCED", -> returns true,
// word = "SEE", -> returns true,
// word = "ABCB", -> returns false.

public class Solution {
      int h;
      int w;
      boolean[][]visit;
    public boolean exist(char[][] board, String word) {
       h = board.length;
       w = board[0].length;
       visit = new boolean[h][w];
       for (int i = 0; i < h; i++){
         for (int j = 0; j < w; j++){
           if (dfs(board, i, j, 0, word)) return true;
         }
       }
       return false;
    }
    private boolean dfs(char[][]board, int i, int j, int start, String word){
      if (start == word.length()) return true;
      if(i < 0 || i >= h || j < 0 || j >= w || visit[i][j] || board[i][j] != word.charAt(start))
        return false;
      visit[i][j] = true;
      if (dfs(board, i-1, j,  start + 1, word) || ) return true;
      if (dfs(board, i+1, j,  start + 1, word)) return true;
      if (dfs(board, i, j-1,  start + 1, word)) return true;
      if (dfs(board, i, j+1,  start + 1, word)) return true;
      visit[i][j] = false;
      return false;
    }
}
