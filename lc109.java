// Given a singly linked list where elements are sorted in ascending order,
// convert it to a height balanced BST.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    private ListNode cur;
    public TreeNode sortedListToBST(ListNode head) {
      if (head == null) return null;
      ListNode dummy = new ListNode(0);
      dummy.next = head;
      int len = 0;
      while(dummy.next != null){
        len++;
        dummy = dummy.next;
      }
      cur = head;
      return helper(0, len - 1);
    }

    private TreeNode helper(int lo, int hi){
      if (lo > hi || cur == null) return null;
      else if (lo == hi) {
        int val = cur.val;
        cur = cur.next;
        return new TreeNode(val);
      }
      else {
        int mid = (lo + hi)/2;
        TreeNode left = helper(lo, mid - 1);
        TreeNode root = new TreeNode(cur.val);
        root.left = left;
        cur = cur.next;
        root.right = helper(mid + 1, hi);
        return root;
      }

    }
}
