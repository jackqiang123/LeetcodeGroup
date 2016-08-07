// Write a program to find the node at which the intersection of two singly linked lists begins.
//
//
// For example, the following two linked lists:
//
// A:          a1 → a2
//                    ↘
//                      c1 → c2 → c3
//                    ↗
// B:     b1 → b2 → b3
// begin to intersect at node c1.
//
//
// Notes:
//
// If the two linked lists have no intersection at all, return null.
// The linked lists must retain their original structure after the function returns.
// You may assume there are no cycles anywhere in the entire linked structure.
// Your code should preferably run in O(n) time and use only O(1) memory.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
          if (headA == null || headB == null) return null;
          int lenA = getLength(headA);
          int lenB = getLength(headB);
          ListNode p1 = lenA >= lenB?headA:headB;
          ListNode p2 = p1 == headA?headB:headA;
          for (int i = 0; i < Math.abs(lenA-lenB); i++) p1 = p1.next;
          while(p1 != p2 && p1 != null && p2 != null) {p1 = p1.next; p2 = p2.next;}
          return (p1 == null || p2 == null) ? null : p1;
    }
    private int getLength(ListNode head){
      int len = 0;
      if (head == null) return len;
      while(head != null) {
        len++; head = head.next;
      }
      return len;
    }
}
