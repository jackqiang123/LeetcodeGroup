// Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
//
// For example:
// Given binary tree [3,9,20,null,null,15,7],
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
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isOrder = true;
        while(!queue.isEmpty()){
          int qsize = queue.size();
          List<Integer> cur = new ArrayList<>();
          for (int i = 0; i < qsize; i++){
            TreeNode curNode = queue.remove();
            if (isOrder) cur.add(curNode.val);
            else cur.add(0, curNode.val);
            if (curNode.left != null) queue.add(curNode.left);
            if (curNode.right != null) queue.add(curNode.right);
          }
          res.add(cur);
          isOrder = !isOrder;
        }
        return res;
    }
}
