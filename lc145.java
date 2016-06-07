// Given a binary tree, return the postorder traversal of its nodes' values.
//
// For example:
// Given binary tree {1,#,2,3},
//    1
//     \
//      2
//     /
//    3
// return [3,2,1].
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
    public List<Integer> postorderTraversal(TreeNode root) {
      List<Integer> res = new ArrayList<Integer>();
      Stack<TreeNode> stack = new Stack<TreeNode>();
      while(root != null)
      {
        stack.push(root);
        res.add(0, root.val);
        root = root.right;
      }
      while(!stack.isEmpty()){
        TreeNode cur = stack.pop();
        cur = cur.left;
        while(cur != null)
        {
          stack.push(cur);
          res.add(0, cur.val);
          cur = cur.right;
        }
      }
      return res;
    }
}
