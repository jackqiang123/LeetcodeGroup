// Given a singly linked list, determine if it is a palindrome.
//
// Follow up:
// Could you do it in O(n) time and O(1) space?
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
      if (head == null || head.next == null) return true;
      ListNode dummy = new ListNode(0);
      dummy.next = head;
      ListNode p1 = dummy;
      ListNode p2 = dummy;
      while(p2 != null && p2.next != null && p2.next.next != null){
        p1 = p1.next;
        p2 = p2.next.next;
      }
      ListNode temp = p1.next;
      p1.next = null;
      p2 = reverse(temp);
      p1 = head;
      while(p1 != null && p2 != null){
        if (p1.val == p2.val){
          p1 = p1.next; p2 = p2.next;
        }
        else return false;
      }
      return true;
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
}
