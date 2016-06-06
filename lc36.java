// Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
//
// The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

// Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
//
// The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

public class Solution {
    public boolean isValidSudoku(char[][] board) {
      List<Set<Character>> rowList = new ArrayList<Set<Character>>();
      List<Set<Character>> colList = new ArrayList<Set<Character>>();
      List<Set<Character>> boxList = new ArrayList<Set<Character>>();
      for (int i = 0; i < 9; i++)
       { rowList.add(new HashSet());
        colList.add(new HashSet());
        boxList.add(new HashSet());}
      for (int i = 0; i < 9; i++){
        for (int j = 0; j < 9; j++){
          char c = board[i][j];
          if (c == '.') continue;
          if (rowList.get(i).contains(c)) return false;
          else rowList.get(i).add(c);
          if (colList.get(j).contains(c)) return false;
          else colList.get(j).add(c);
          int boxIndex = (i/3)*3 + (j/3);
          if (boxList.get(boxIndex).contains(c)) return false;
          else boxList.get(boxIndex).add(c);
        }
      }
      return true;
    }
}
