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
        if(headA == null || headB == null) return null;
        
        ListNode a = headA;
        ListNode b = headB;
        
        int length = 0;

        while(a != null){
            a = a.next;
            length++;
        }
        
        while(b != null){
            b = b.next;
            length--;
        }
        
        ListNode pos1 = headA;
        ListNode pos2 = headB;

        while(length > 0){
            pos1 = pos1.next;
            length--;
        }
        
        while(length < 0){
            pos2 = pos2.next;
            length++;
        }
        
        while(pos1 != pos2){
            pos1 = pos1.next;
            pos2 = pos2.next;
        }
        
        return pos1;
    }
}