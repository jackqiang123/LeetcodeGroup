// Given a binary tree, return the inorder traversal of its nodes' values.
//
// For example:
// Given binary tree {1,#,2,3},
//
//    1
//     \
//      2
//     /
//    3
//
// return [1,3,2].
//
// Note: Recursive solution is trivial, could you do it iteratively?
//
// confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
//
// Subscribe to see which companies asked this question
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
    public List<Integer> inorderTraversal(TreeNode root) {
      List<Integer> res = new ArrayList<Integer>();
      Stack<TreeNode> stack = new Stack<TreeNode>();
      while(root != null){
        stack.push(root);
        root = root.left;
      }
      while(!stack.isEmpty()){
        TreeNode cur = stack.pop();
        res.add(cur.val);
        cur = cur.right;
        while(cur != null)
        {
            stack.push(cur);
            cur = cur.left;
        }        
      }
      return res;
    }
}
