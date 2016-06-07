// Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
// For example:
// Given the below binary tree and sum = 22,
//
//              5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
//
// return
//
// [
//   [5,4,11,2],
//   [5,8,4,5]
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
    List<List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
      res = new ArrayList<List<Integer>>();
      if (root == null) return res;
      dfs(new ArrayList<Integer>(), sum, root);
      return res;
    }
    private void dfs(List<Integer> cur, int target, TreeNode root){
      if (root.left == null && root.right == null){
        if (root.val == target){
          List<Integer> curRes = new ArrayList<Integer>(cur);
          curRes.add(root.val);
          res.add(curRes);
        }
      }
      else{
        cur.add(root.val);
        if (root.left != null)
            dfs(cur, target - root.val, root.left);
        if (root.right != null)
            dfs(cur, target - root.val, root.right);
        cur.remove(cur.size()-1);
      }
    }
}
