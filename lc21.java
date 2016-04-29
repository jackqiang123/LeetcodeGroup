//Merge two sorted linked lists and return it as a new list.
// The new list should be made by splicing together the nodes of the first two lists.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode dummy = res;
        while(true){
          if (l1 != null && l2 != null){
            if (l1.val < l2.val){
              res.next = l1;
              res = res.next;
              l1 = l1.next;
            }
            else{
              res.next = l2;
              res = res.next;
              l2 = l2.next;
            }
          }
          else if (l1 != null){
            res.next = l1; break;
          }
          else {
            res.next = l2; break;
          }
        }
        return dummy.next;
    }
}
