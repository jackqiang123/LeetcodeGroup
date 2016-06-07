// Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
//
// For example:
// Given binary tree {3,9,20,#,#,15,7},
//     3
//    / \
//   9  20
//     /  \
//    15   7
// return its zigzag level order traversal as:
// [
//   [3],
//   [20,9],
//   [15,7]
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
      List<List<Integer>> res = new ArrayList<List<Integer>>();
      Queue<TreeNode> queue = new LinkedList<TreeNode>();
      if (root == null) return res;
      queue.add(root);
      queue.add(null);
      List<Integer> curRes = new ArrayList<Integer>();
      boolean isRev = false;
      while(!queue.isEmpty()){
        TreeNode cur = queue.remove();
        if(cur != null){
          if (!isRev)
            curRes.add(cur.val);
          else curRes.add(0, cur.val);
          if (cur.left != null) queue.add(cur.left);
          if (cur.right != null) queue.add(cur.right);
        }
        else{
          if (!queue.isEmpty())
            queue.add(null);
          res.add(curRes);
          curRes = new ArrayList<Integer>();
          isRev = !isRev;
        }
      }
      return res;
    }
}
