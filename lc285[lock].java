// Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
//
// Note: If the given node has no in-order successor in the tree, return null.
public class Solution{
  public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    if (root == null || p == null) return null;
    if (p.right != null){
      p = p.right;
      while(p.left != null) p = p.left;
      return p;
    }
    else {
      while(root != null){
        if (root.left == p)
          return root;
        else if (root.val < p.val) root = root.right;
        else root = root.left;
      }
    }
    return null;
  }
}
