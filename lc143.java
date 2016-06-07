// Given a singly linked list L: L0→L1→…→Ln-1→Ln,
// reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
//
// You must do this in-place without altering the nodes' values.
//
// For example,
// Given {1,2,3,4}, reorder it to {1,4,2,3}.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
      if (head == null) return;
      ListNode median = findMedian(head);
      merge(head, reverse(median));
    }
    private ListNode findMedian(ListNode head){
      if (head == null || head.next == null) return null;
      ListNode p1 = new ListNode(0);
      p1.next = head;
      ListNode p2 = p1;
      while(p2.next != null && p2.next.next != null){
        p2 = p2.next.next;
        p1 = p1.next;
      }
      p2 = p1.next;
      p1.next = null;
      return p2;
    }
    private ListNode reverse(ListNode head){
      ListNode dummy = new ListNode(0);
      while(head != null){
        ListNode temp = head.next;
        head.next = dummy.next;
        dummy.next = head;
        head = temp;
      }
      return dummy.next;
    }
    private ListNode merge(ListNode h1, ListNode h2){
      ListNode res = new ListNode(0);
      ListNode dummy = res;
      while(h1 != null && h2 != null){
        dummy.next = h1;
        h1 = h1.next;
        dummy.next.next = h2;
        h2 = h2.next;
        dummy = dummy.next.next;
      }
      return res.next;
    }
}
