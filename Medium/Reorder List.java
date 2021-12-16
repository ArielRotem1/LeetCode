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
    ListNode result = null;
    public void reorderList(ListNode head) {
        if(head.next == null) return;
        
        result = head;
        
        solve(head);
    }
    
    boolean solve(ListNode pos){
        if(pos == null){
            return true;
        }
        
        boolean res = solve(pos.next);
        
        if(!res) return false;
        
        if(result.next == pos || result == pos){
            pos.next = null;
            return false;
        }
        
        ListNode next = result.next;
        
        result.next = pos;
        pos.next = next;
        result = next;
        
        return true;
    }
}