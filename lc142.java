// Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
//
// Note: Do not modify the linked list.
//
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
      if (head == null) return null;
      ListNode p1 = head;
      ListNode p2 = head;
      while(p2 != null && p2.next != null && p2.next.next != null){
          p2 = p2.next.next;
          p1 = p1.next;
          if (p1 == p2) break;
      }
      if (p2 == null || p2.next == null || p2.next.next == null) return null;
      if (p1 != p2) return null;
      p1 = head;
      while(p1 != p2){
        p1 = p1.next;
        p2 = p2.next;
      }
      return p1;
    }
}
