/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode pos = head;
        boolean start = true;
        
        
        if(pos != null && pos.next != null){
            ListNode first = pos;
            ListNode second = pos.next;
            first.next = second.next;
            second.next = first;
            head = second;
        }
        else return head;
        
        while(pos.next != null && pos.next.next != null){
            ListNode a = pos.next;
            ListNode b = pos.next.next;
            pos.next = b;
            pos = a;
            
            a.next = b.next;
            b.next = a;
        }
        
        return head;
        
    }
}