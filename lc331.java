// One way to serialize a binary tree is to use pre-order traversal. When we encounter a non-null node,
// we record the node's value. If it is a null node, we record using a sentinel value such as #.
//
//      _9_
//     /   \
//    3     2
//   / \   / \
//  4   1  #  6
// / \ / \   / \
// # # # #   # #
// For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#",
// where # represents a null node.
//
// Given a string of comma separated values, verify whether it is a correct preorder traversal serialization
// of a binary tree. Find an algorithm without reconstructing the tree.
//
// Each comma separated value in the string must be either an integer or a character '#' representing null pointer.
//
// You may assume that the input format is always valid, for example it could never contain two consecutive commas
// such as "1,,3".
//
// Example 1:
// "9,3,4,#,#,1,#,#,2,#,6,#,#"
// Return true
//
// Example 2:
// "1,#"
// Return false
//
// Example 3:
// "9,#,#,1"
// Return false

public class Solution {
    public boolean isValidSerialization(String preorder) {
      if (preorder == null || preorder.length() == 0) return false;
      int treeCount = 0;
      String[]nodes = preorder.split(",");
      Stack<Integer> stack = new Stack();
      int []child = new int[nodes.length];
      for (int i = 0; i < nodes.length; i++){
        String cur = nodes[i];
        if (cur.equals("#")){
          if (stack.isEmpty()){
            return nodes.length == 1;
          }
          else {
            child[stack.peek()]++;
            while(!stack.isEmpty()){
              if (child[stack.peek()] == 2)
                stack.pop();
              else break;
              if (!stack.isEmpty()) child[stack.peek()]++;
              else return i == nodes.length - 1;
            }
          }
        }
        else {
          stack.push(i);
        }
      }
      return stack.isEmpty();
    }
}
