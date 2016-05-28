// Problem Description:
//
// You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.
//
// Write a function to determine if the starting player can guarantee a win.
//
// For example, given s = "++++", return true. The starting player can guarantee a win by flipping the middle "++" to become "+--+".
//
// Follow up:
// Derive your algorithm's runtime complexity.

public class Solution {
 public boolean canWin(String s) {
  List<String> res = next(s);
  if (res.size() == 0) return false;
  for (String n : res){
    if (!canWin(n)) return true;
  }
  return false;
 }

 private List<String> next(String s) {
   List<String> res = new ArrayList<String>();
   char []array = s.toCharArray();
   for (int i = 1; i < array.length; i++){
     if (array[i] == '+' && array[i-1] == '+'){
       array[i] = '-';
       array[i-1] = '-';
       res.add(String.valueOf(array));
       array[i] = '+';
       array[i-1] = '+';
     }
   }
   return res;
 }
}
