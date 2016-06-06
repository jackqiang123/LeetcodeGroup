// Given a 2D board and a word, find if the word exists in the grid.
//
// The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
//
// For example,
// Given board =
//
// [
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
// ]
//
// word = "ABCCED", -> returns true,
// word = "SEE", -> returns true,
// word = "ABCB", -> returns false.
public class Solution {
    private boolean [][]visit;
    public boolean exist(char[][] board, String word) {
        int h = board.length;
        int w = board[0].length;
        visit = new boolean[h][w];
        for (int i = 0; i < h; i++){
          for (int j = 0; j < w; j++)
          {
            if (dfs(board, i, j, word, 0))
              return true;
          }
        }
        return false;
    }

    private boolean dfs(char[][]board, int i, int j, String word, int index){
      if (index == word.length()) return true;
      if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visit[i][j]) return false;
      if (word.charAt(index) != board[i][j]) return false;
      visit[i][j] = true;
      if (dfs(board, i-1,j,word,index+1) || dfs(board, i+1,j,word,index+1) || dfs(board, i,j-1,word,index+1) || dfs(board, i,j+1,word,index+1))
        return true;
      visit[i][j] = false;
      return false;

    }
}
