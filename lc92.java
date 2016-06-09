// Reverse a linked list from position m to n. Do it in-place and in one-pass.
//
// For example:
// Given 1->2->3->4->5->NULL, m = 2 and n = 4,
//
// return 1->4->3->2->5->NULL.
//
// Note:
// Given m, n satisfy the following condition:
// 1 ≤ m ≤ n ≤ length of list.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
      ListNode dummy = new ListNode(0);
      dummy.next = head;
      ListNode res = dummy;
      ListNode p1 = dummy;
      ListNode p2 = dummy;
      int index = 1;
      if (m == n) return head;
      while(index != m){
        index++;
        p1 = p1.next;
      }
      p2 = p1.next;
      ListNode tail = p2;
      while(index <= n){
        index++;
        ListNode temp = p2.next;
        p2.next = p1.next;
        p1.next = p2;
        p2 = temp;
      }
      tail.next = p2;
      return res.next;
    }
}
