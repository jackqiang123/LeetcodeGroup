// Given a binary tree, return all root-to-leaf paths.
//
// For example, given the following binary tree:
//
//    1
//  /   \
// 2     3
//  \
//   5
// All root-to-leaf paths are:
//
// ["1->2->5", "1->3"]
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
    List<String> res;
    public List<String> binaryTreePaths(TreeNode root) {
      res = new ArrayList<String>();
      if (root == null) return res;
      helper(root, new ArrayList<Integer>());
      return res;
    }

    private void helper(TreeNode root, List<Integer> cur){
      if (root.left == null && root.right == null){
        cur.add(root.val);
        res.add(getResult(cur));
        cur.remove(cur.size()-1);
      }
      else {
        cur.add(root.val);
        if (root.left != null) helper(root.left, cur);
        if (root.right != null) helper(root.right, cur);
        cur.remove(cur.size()-1);
      }
    }

    private String getResult(List<Integer> cur){
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < cur.size(); i++){
        if (i != cur.size()-1)
        sb.append(cur.get(i)).append("->");
        else sb.append(cur.get(i));
      }
      return sb.toString();
    }
}
