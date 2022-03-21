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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1) return head;
        
        return solve(head, 0, k);
    }
    
    public ListNode solve(ListNode head, int count, int k){
        
        if(head == null) return null;
        
        head.next = solve(head.next, (count + 1) % k, k);
        
        if(count == 0){
            head = reversePart(head, k);
        }
        
        return head;
    }
    
    public ListNode reversePart(ListNode head, int size){
        if(size == 1) return head;
        
        ListNode pos = head;
        int savedSize = size;
        
        while(size > 1){
            pos = pos.next;
            if(pos == null) return head;
            size--;
        }
        
        ListNode temp = head.next;
        head.next = pos.next;
        
        while(savedSize > 1){
            ListNode temp2 = temp.next;
            temp.next = head;
            head = temp;
            temp = temp2;
            savedSize--;
        }
        
        return head;
    }
}