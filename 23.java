// Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
      return helper(lists, 0, lists.length - 1);
    }
    private ListNode helper(ListNode[]lists, int start, int end){
      if (start > end) return null;
      if (start == end) return lists[start];
      int mid = (start + end)/2;
      ListNode left = helper(lists, start, mid);
      ListNode right = helper(lists, mid + 1, end);
      return merge(left, right);
    }
    private ListNode merge(ListNode left, ListNode right){
      ListNode res = new ListNode(0);
      ListNode dummy = res;
      while(left != null || right != null){
        if (left != null && right != null) {
          if (left.val < right.val) {
            dummy.next = left;
            left = left.next;
          }
          else {
            dummy.next = right;
            right = right.next;
          }
          dummy = dummy.next;
        }
        else if (left != null){
          dummy.next = left; break;
        }
        else {
          dummy.next = right; break;
        }
      }
      return res.next;
    }
}
