// Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
// using master theorem, T(n) = 2T(n/2) + n/2 - > T(n) = nlogn. The naive one is O(n^2)
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
        int len = lists.length;
        if (len == 0) return null;
        if (len == 1) return lists[0];
        return helper(lists, 0 , len-1);
    }

    private ListNode helper(ListNode [] lists, int start, int end){
      if (end < start) return null;
      if (start == end) return lists[start];
      int mid = (start + end)/2;
      ListNode left = helper(lists, start, mid);
      ListNode right = helper(lists, mid + 1, end);
      return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right){
      if (left == null) return right;
      if (right == null) return left;
      ListNode dummy = new ListNode(0);
      ListNode res = dummy;
      while(left != null || right != null){
        if (left != null && right != null){
          if (left.val < right.val){
            dummy.next = left;
            left = left.next;
            dummy = dummy.next;
          }
          else {
            dummy.next = right;
            right = right.next;
            dummy = dummy.next;
          }
        }else if (left != null){
          dummy.next = left; return res.next;
        }else {
          dummy.next = right; return res.next;
        }
      }
      return res.next;
    }
}
