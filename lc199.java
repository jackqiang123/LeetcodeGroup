// Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
//
// For example:
// Given the following binary tree,
//
//    1            <---
//  /   \
// 2     3         <---
//  \     \
//   5     4       <---
//
// You should return [1, 3, 4].
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
    public List<Integer> rightSideView(TreeNode root) {
      List<Integer> res = new ArrayList<Integer>();
      if (root == null) return res;
      Queue<TreeNode> queue = new LinkedList<TreeNode>();
      queue.add(root);
      queue.add(null);
      TreeNode last = null;
      while(!queue.isEmpty()){
        TreeNode cur = queue.remove();
        if (cur != null){
          last = cur;
          if (cur.left != null) queue.add(cur.left);
          if (cur.right != null) queue.add(cur.right);
        }
        else{
          if (!queue.isEmpty()){
            queue.add(null);
          }
          res.add(last.val);
        }
      }
      return res;
    }
}
