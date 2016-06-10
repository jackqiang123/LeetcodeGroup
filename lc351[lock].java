// Given an Android 3x3 key lock screen and two integers m and n, where 1 ≤ m ≤ n ≤ 9, count the total number of unlock patterns of the Android lock screen, which consist of minimum of m keys and maximum n keys.
//
// Rules for a valid pattern:
//
// Each pattern must connect at least m keys and at most n keys.
// All the keys must be distinct.
// If the line connecting two consecutive keys in the pattern passes through any other keys, the other keys must have previously selected in the pattern. No jumps through non selected key is allowed.
// The order of keys used matters.
//
//
//
//
// Explanation:
//
// | 1 | 2 | 3 |
// | 4 | 5 | 6 |
// | 7 | 8 | 9 |
//
//
// Invalid move: 4 - 1 - 3 - 6
// Line 1 - 3 passes through key 2 which had not been selected in the pattern.
//
// Invalid move: 4 - 1 - 9 - 2
// Line 1 - 9 passes through key 5 which had not been selected in the pattern.
//
// Valid move: 2 - 4 - 1 - 3 - 6
// Line 1 - 3 is valid because it passes through key 2, which had been selected in the pattern
//
// Valid move: 6 - 5 - 4 - 1 - 9 - 2
// Line 1 - 9 is valid because it passes through key 5, which had been selected in the pattern.
//
// Example:
// Given m = 1, n = 1, return 9.
//
// Credits:
// Special thanks to @elmirap for adding this problem and creating all test cases.
public class Solution {
    int min;
    int max;
    int res;
    int curRes;
    public int numberOfPatterns(int m, int n) {
      min = m; max = n; res = 0;
      helper(0, new ArrayList());
      res += (4*curRes);
      curRes = 0;
      helper(1, new ArrayList());
      res += (4*curRes);
      curRes = 0;
      helper(4, new ArrayList());
      res += (curRes);
      return res;
    }
    private void helper(int num, List<Integer> cur){
        cur.add(num);
        if (cur.size() >= m){
          curRes++;
          if (cur.size() == n) return;
        }
        if (cur.size() < n){
          for (int i = 0; i <= 8; i++){
              if (canVisit(cur, i)){
                helper(i, cur);
              }
          }
        }
        cur.remove(num);
    }
    private boolean canVisit(List<Integer>cur, int num){
      if (cur.contains(num)) return false;
      if (cur.size() == 0) return true;
      int from = cur.get(cur.size() - 1);// from to num
      int sx = from/3;
      int sy = from%3;
      int dx = num/3;
      int dy = num%3;
      if (sx == dx){
        if (Math.abs(sy - dy)==1) return true;
        int midy = (sy + dy)/2;
        int mid = sx*3 + midy;
        if (cur.contains(mid)) return true;
        else return false;
      }
      else if (sy == dy){
        if (Math.abs(sx - dx)==1) return true;
        int midx = (sx + dx)/2;
        int mid = midx*3 + sy;
        if (cur.contains(mid)) return true;
        else return false;
      }
      else if (from == 4 || num == 4)
        return true;
      else if (dx - sx == dy - sy || dx - sx == sy - dy){
        if (cur.contains(4)) return true;
        else return false;
      }
      return true;
    }
  }
