// You have a number of envelopes with widths and heights given as a pair of integers (w, h). One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.
//
// What is the maximum number of envelopes can you Russian doll? (put one inside other)
//
// Example:
// Given envelopes = [[5,4],[6,4],[6,7],[2,3]], the maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
      Arrays.sort(envelopes, new Comparator<int[]>(){
        public int compare(int[]e1, int[]e2){
          if (e1[0] != e2[0]) return Integer.compare(e1[0], e2[0]);
          return -Integer.compare(e1[1],e2[1]);//we want to maintain this reverse order,
          // because when equals, we want to jump all elements that are the same height
          // when height are the same, and sort width in order, then we get same boundary
          // height while width diff still lead to nest.
        }
      });
      int []numberAtIndex = new int[envelopes.length];
      int len = 0;
      for (int[] e : envelopes){
        int x = e[1];
        int i = Arrays.binarySearch(numberAtIndex, 0, len, x);
        if (i < 0) numberAtIndex[-(i+1)] = x;
        if (-(i+1) == len) len++;
      }
      return len;
    }
}
