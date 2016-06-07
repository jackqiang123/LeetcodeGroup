// Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
//
// For example:
// Given binary tree {3,9,20,#,#,15,7},
//     3
//    / \
//   9  20
//     /  \
//    15   7
// return its bottom-up level order traversal as:
// [
//   [15,7],
//   [9,20],
//   [3]
// ]
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
      List<List<Integer>> res = new ArrayList<List<Integer>>();
      Queue<TreeNode> queue = new LinkedList<TreeNode>();
      if (root == null) return res;
      queue.add(root);
      queue.add(null);
      List<Integer> curRes = new ArrayList<Integer>();
      while(!queue.isEmpty()){
        TreeNode cur = queue.remove();
        if(cur != null){
          curRes.add(cur.val);
          if (cur.left != null) queue.add(cur.left);
          if (cur.right != null) queue.add(cur.right);
        }
        else{
          if (!queue.isEmpty())
            queue.add(null);
          res.add(0, curRes);
          curRes = new ArrayList<Integer>();
        }
      }
      return res;
    }
}
