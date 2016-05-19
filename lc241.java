// Given a string of numbers and operators, return all possible results from
// computing all the different possible ways to group numbers and operators.
// The valid operators are +, - and *.
//
//
// Example 1
// Input: "2-1-1".
//
// ((2-1)-1) = 0
// (2-(1-1)) = 2
// Output: [0, 2]
//
//
// Example 2
// Input: "2*3-4*5"
//
// (2*(3-(4*5))) = -34
// ((2*3)-(4*5)) = -14
// ((2*(3-4))*5) = -10
// (2*((3-4)*5)) = -10
// (((2*3)-4)*5) = 10
// Output: [-34, -14, -10, -10, 10]
public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
      int len = input.length();
      List<Integer> operIndx = new ArrayList();
      for (int i = 0; i < len; i++)
      {
        if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*'){
          operIndx.add(i);
        }
      }
      List<Integer> res = new ArrayList();
      if (operIndx.size() == 0){
        res.add(Integer.parseInt(input));
      }
      else{
          for (int i : operIndx){
            char oper = input.charAt(i);
            List<Integer> leftResult = diffWaysToCompute(input.substring(0, i));
            List<Integer> rightResult = diffWaysToCompute(input.substring(i + 1));
            for (Integer left : leftResult){
              for (Integer right : rightResult){
                int curRest = 0;
                if (oper == '+') curRest = left + right;
                else if (oper == '-') curRest = left - right;
                else if (oper == '*') curRest = left * right;
                res.add(curRest);
              }
            }
          }
      }
      return res;
    }
}
