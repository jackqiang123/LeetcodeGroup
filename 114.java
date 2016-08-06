// Given a binary tree, flatten it to a linked list in-place.
//
// For example,
// Given
//
//         1
//        / \
//       2   5
//      / \   \
//     3   4   6
//
// The flattened tree should look like:
//
//   1
//    \
//     2
//      \
//       3
//        \
//         4
//          \
//           5
//            \
//             6

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
    TreeNode p = null;
    public void flatten(TreeNode root) {
      if (root == null) return;
      TreeNode left = root.left;
      root.left = null;
      TreeNode right = root.right;
      p = root;
      flatten(left);
      root.right = left;
      TreeNode endNode = p;
      flatten(right);
      endNode.right = right;
    }
}
