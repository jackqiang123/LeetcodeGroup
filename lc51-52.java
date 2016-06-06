// Given an integer n, return all distinct solutions to the n-queens puzzle.
//
// Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
//
// For example,
// There exist two distinct solutions to the 4-queens puzzle:
//
// [
//  [".Q..",  // Solution 1
//   "...Q",
//   "Q...",
//   "..Q."],
//
//  ["..Q.",  // Solution 2
//   "Q...",
//   "...Q",
//   ".Q.."]
// ]
public class Solution {
      List<List<String>> res;
      char [][] table;
    public List<List<String>> solveNQueens(int n) {
      res = new ArrayList<List<String>>();
      if (n == 0) return res;
      table = new char[n][n];
      dfs(0);// starting line number
      return res;
    }
    private void dfs(int start){
      int dim = table.length;
      if (start >= dim){
        res.add(getCurrentResult());
      }
      else{
        for (int i = 0; i < dim; i++){
          if (isValid(start,i)){
            table[start][i] = 'Q';
            dfs(start+1);
            table[start][i] = '.';
          }
        }
      }
    }

    private List<String> getCurrentResult(){
      List<String> cur = new ArrayList<String>();
      for (int i = 0; i < table.length; i++){
        StringBuilder curLine = new StringBuilder();
        for (int j = 0; j < table.length; j++){
          if (table[i][j] == 'Q')
            curLine.append('Q');
          else curLine.append('.');
        }
        cur.add(curLine.toString());
      }
      return cur;
    }

    private boolean isValid(int x, int y){
      for (int i = 0; i < x; i++){
        if (table[i][y] == 'Q') return false;
      }

      int j = 1;
      for (int i = x - 1; i>=0 && y -j >= 0; i--){
        if (table[i][y-j] == 'Q') return false;
        j++;
      }
      j = 1;
      for (int i = x - 1; i>=0 && y + j < table.length; i--){
        if (table[i][y+j] == 'Q') return false;
        j++;
      }
      return true;
    }
}
