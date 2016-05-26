// Problem Description:
//
// Given a non-empty binary search tree and a target value,
// find k values in the BST that are closest to the target.
//
// Note:
//
//     Given target value is a floating point.
//     You may assume k is always valid, that is: k ≤ total nodes.
//     You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
// Follow up:
// Assume that the BST is balanced, could you solve it in less than O(n) runtime (where n = total nodes)?
//
// Hint:
//
//     Consider implement these two helper functions:
//         getPredecessor(N), which returns the next smaller node to N.
//         getSuccessor(N), which returns the next larger node to N.
//     Try to assume that each node has a parent pointer, it makes the problem much easier.
//     Without parent pointer we just need to keep track of the path from the root to the current
//     node using a stack.
//     You would need two stacks to track the path in finding predecessor and successor node separately.
public class Solution{
    TreeNode root;
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
      this.root = root;
      List<Integer> res = new ArrayList<Integer>();
      TreeNode left = findCrossOver(target);
      TreeNode right = findSuccessor(left);
      if (left.val > target){
          right = cur;
          left = null;
      }
      for (int i = 0; i < k; i++){
        if (compare(left, right, target))
        {
          res.add(left.val);
          left = getPredecessor(left);
        }
        else {
          res.add(right.val);
          right = getSuccessor(right);
        }
      }
      return res;
   }

   private TreeNode findCrossOver(double target){
     TreeNode cur = root;
     while(cur != null){
       if (cur.val == target) return cur;
       else if (cur.val > target){
         if (cur.left == null) return cur;
         else if (cur.left.val < target) return cur.left;
         else cur = cur.left;
       }else {
         if (cur.right == null || cur.right.val > target) return cur;
         else cur = cur.right;
       }
     }
     return cur;
   }

   private boolean compare(TreeNode left, TreeNode right, double target){
     if (right == null) return true;
     if (left == null) return false;
     return Math.abs(left.val - target) = Math.abs(right.val - target);
   }

   private TreeNode getPredecessor(TreeNode node){
     if (node == null) return null;
     if (node.left != null){
       TreeNode res = node.left;
       while(res.right != null)
        res = res.right;
       return res;
     }
     else {
       while(root != null){
         if (root.right == node) return root;
         if (root.val < node.val) root = root.right;
         else root = root.left;
       }
     }
     return null;
   }

   private TreeNode getSuccessor(TreeNode node){
     if (node == null) return null;
     if (node.right != null){
       TreeNode res = node.right;
       while(res.left != null)
        res = res.left;
       return res;
     }
     else {
       while(root != null){
         if (root.left == node) return root;
         if (root.val < node.val) root = root.left;
         else root = root.right;
       }
     }
     return null;
   }
 }
