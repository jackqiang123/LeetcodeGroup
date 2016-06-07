// There are N children standing in a line. Each child is assigned a rating value.
//
// You are giving candies to these children subjected to the following requirements:
//
//    Each child must have at least one candy.
//    Children with a higher rating get more candies than their neighbors.
//
// What is the minimum candies you must give?
public class Solution {
    public int candy(int[] r) {
      int []c = new int[r.length];
      for (int i = 0; i < c.length; i++)
        c[i] = 1;
      for (int i = 1; i < c.length; i++){
        if (r[i] > r[i-1])
          c[i] = c[i-1] + 1;
      }
      for (int i = c.length - 2; i >= 0; i--){
        if (r[i] > r[i + 1] && c[i] <= c[i+1])
          c[i] = c[i+1] + 1;
      }
      int sum = 0;
      for (int s : c)
        sum += s;
      return sum;
    }
}
