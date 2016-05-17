// Given a binary tree, return the preorder traversal of its nodes' values.
//
// For example:
// Given binary tree {1,#,2,3},
//    1
//     \
//      2
//     /
//    3
// return [1,2,3].
//
// Note: Recursive solution is trivial, could you do it iteratively?
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
      List<Integer> res = new ArrayList<Integer>();
      Stack<TreeNode> stack = new Stack<TreeNode>();
      while(root != null)
      {
        stack.push(root);
        res.add(root.val);
        root = root.left;
      }
      while(!stack.isEmpty()){
        TreeNode cur = stack.pop();
        cur = cur.right;
        while(cur != null)
        {
          stack.push(cur);
          res.add(cur.val);
          cur = cur.left;
        }
      }
      return res;
    }
}
