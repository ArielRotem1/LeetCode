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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        
        ListNode posList = head, result = new ListNode(0);
        ListNode pos = result;
        
        while(posList != null){
            if(posList.next == null || posList.val != posList.next.val){
                pos.next = new ListNode(posList.val);
                pos = pos.next;
            }
            else{
                while(posList.next != null && posList.next.val == posList.val) posList = posList.next;
            }
            
            posList = posList.next;
        }
        
        return result.next;
    }
}
