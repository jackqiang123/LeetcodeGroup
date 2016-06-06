// Given a sorted linked list, delete all duplicates such that each element appear only once.
//
// For example,
// Given 1->1->2, return 1->2.
// Given 1->1->2->3->3, return 1->2->3.
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
      ListNode p2 = p1.next;
      while(p2 != null && p2.next != null){
        if (p2.val == p2.next.val)
          p2 = p2.next;
        else {
          p1.next = p2;
          p1 = p2;
          p2 = p1.next;
        }
      }
      p1.next = p2;
      return res.next;
    }
}
