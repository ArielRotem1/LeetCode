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
    public ListNode partition(ListNode head, int x) {
        //Time: O(n)
        //Space: O(1)
        if(head == null) return null;
        
        ListNode res = head;
        ListNode pos = head;
        ListNode start = null;
        ListNode prev = null;
        
        while(pos != null){
            
            if(pos.val < x){
                if(prev != null && prev.val >= x){
                    ListNode nextPos = pos.next;
                    
                    prev.next = pos.next;

                    if(start != null){
                        pos.next = start.next;
                        start.next = pos;
                        start = start.next;
                    }
                    else{
                        pos.next = head;
                        start = pos;
                        res = pos;
                    }

                    pos = nextPos;
                }
                else{
                    start = pos;
                    
                    prev = pos;
                    pos = pos.next;
                }
            }
            else{
                prev = pos;
                pos = pos.next;
            }
        }
        
        return res;
    }
}
