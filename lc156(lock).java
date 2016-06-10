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
  // this question is more like a recrusion way of reverse a linkedlist.
  // first reverse the left child. then make the left left point to right, left right point to parent.
  public TreeNode UpsideDownBinaryTree(TreeNode root) {
    if (root == null) return root;
    TreeNode parent = root; TreeNode left = root.left; TreeNode right = root.right;
    if (left != null)
    {
        TreeNode newRoot = UpsideDownBinaryTree(left);
        left.left = right;
        left.right = parent;
        return newRoot;
    }
      return root; // this case means root is a leaf node, thus do nothing.
  }
  }
}
