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
    private ListNode mainHead;
    
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;
        
        int size = 0;
        ListNode pos = head;
        
        while(pos != null){
            pos = pos.next;
            size++;
        }
        
        mainHead = head;
        
        solve(head, size - k % size - 2);
        
        return mainHead;
    }
    
    private ListNode solve(ListNode head, int n){
        if(head.next != null){
            ListNode res = solve(head.next, n - 1);
            if(n >= 0) return null;
            
            head.next = null;      
            res.next = mainHead;
            mainHead = res;
        }
        
        return head;
    }
}
