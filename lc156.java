// Given a binary tree where all the right nodes are either leaf nodes with a sibling
// (a left node that shares the same parent node) or empty, flip it upside down and turn it into a
//  tree where the original right nodes turned into left leaf nodes. Return the new root.
//
// For example:
// Given a binary tree {1,2,3,4,5},
// 1
// / \
// 2 3
// / \
// 4 5
//
// return the root of the binary tree [4,5,2,#,#,3,1].
// 4
// / \
// 5 2
//   / \
//  3 1
public class Solution{
  public TreeNode UpsideDownBinaryTree(TreeNode root) {
    if (root == null || (root.left == null && root.right == null)) return root;
    TreeNode cur = root;
    while(cur.left != null && cur.left.left != null){
      cur = cur.left;
    }
    TreeNode newRoot = cur.left;
    newRoot.left = cur.right;
    cur.left = null;
    cur.right = null;
    newRoot.right = UpsideDownBinaryTree(root);
    return newRoot;
  }
}
