// Given a list, rotate the list to the right by k places, where k is non-negative.
//
// For example:
// Given 1->2->3->4->5->NULL and k = 2,
// return 4->5->1->2->3->NULL.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
      ListNode dummy = new ListNode(0);
      dummy.next = head;
      ListNode res = dummy;
      int len = 0;
      while(dummy.next != null){
        len++;
        dummy = dummy.next;
      }
      if (len <= 1|| k == 0) return head;
      k = k % len;
      if (k == 0) return head;
      ListNode p1 = res;
      ListNode p2 = res;
      while(p1.next != null){
        p1 = p1.next;
        if (k > 0) k--;
        else p2 = p2.next;
      }
      res = p2.next;
      p2.next = null;
      p1.next = head;
      return res;
    }
}
