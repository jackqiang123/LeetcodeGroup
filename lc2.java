/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// You are given two linked lists representing two non-negative numbers.
// The digits are stored in reverse order and each of their nodes contain a single digit.
// Add the two numbers and return it as a linked list.
//
// Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
// Output: 7 -> 0 -> 8

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
          ListNode res = new ListNode(0);
          ListNode head = res;
          int bit = 0;
          while(l1 != null || l2 != null){
            if (l1 != null && l2 != null){
              int value = l1.val + l2.val + bit;
              bit = value/10;
              res.next = new ListNode(value % 10);
              l1 = l1.next;
              l2 = l2.next;
              res = res.next;
            }
            else if (l1 != null){
              int value = l1.val + bit;
              bit = value/10;
              l1 = l1.next;
              res.next = new ListNode(value % 10);
              res = res.next;
            }
            else {
              int value = l2.val + bit;
              bit = value/10;
              l2 = l2.next;
              res.next = new ListNode(value % 10);
              res = res.next;
            }
          }
          if (bit != 0)
            res.next = new ListNode(bit);
          return head.next;
    }
}
