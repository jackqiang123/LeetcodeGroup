// Follow up for problem "Populating Next Right Pointers in Each Node".
//
// What if the given tree could be any binary tree? Would your previous solution still work?
//
// Note:
//
//     You may only use constant extra space.
//
// For example,
// Given the following binary tree,
//
//          1
//        /  \
//       2    3
//      / \    \
//     4   5    7
//
// After calling your function, the tree should look like:
//
//          1 -> NULL
//        /  \
//       2 -> 3 -> NULL
//      / \    \
//     4-> 5 -> 7 -> NULL
/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
    // run level-order trasval
    if (root == null) return;
    Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
    queue.add(root);
    queue.add(null);
    TreeLinkNode last = new TreeLinkNode(0);
    while(!queue.isEmpty()){
      TreeLinkNode cur = queue.remove();
      if (cur != null){
        last.next = cur;
        if (cur.left != null) queue.add(cur.left);
        if (cur.right != null) queue.add(cur.right);
        last = last.next;
      }
      else {
        if (queue.isEmpty()){
          break;
        }
        queue.add(null);
        last = new TreeLinkNode(0);
      }
    }
    }
}
