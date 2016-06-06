//
// Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
//
// For example,
// Given 1->2->3->3->4->4->5, return 1->2->5.
// Given 1->1->1->2->3, return 2->3.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
      ListNode dummy = new ListNode(0);
      dummy.next = head;
      ListNode res = dummy;
      ListNode p1 = dummy;
      ListNode p2;
      while(p1 != null && p1.next != null){
            if (p1.next.next == null){
              return res.next;
            }
            else {
              if (p1.next.next.val != p1.next.val)
                p1 = p1.next;
              else {
                int toRemove = p1.next.val;
                p2 = p1.next;
                while(p2 != null && p2.val == toRemove)
                  p2 = p2.next;
                p1.next = p2;
              }
            }
      }
      return res.next;
    }
}
