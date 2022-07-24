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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        //Time: O(n)
        //Space: O(n)
        Stack<ListNode> stack = new Stack<>();
        
        ListNode start = null;
        ListNode pos = head;
        
        int index = 1;
        
        while(index <= right){
            
            if(index < left) start = pos;
            else stack.push(pos);
            
            index++;
            pos = pos.next;
        }
        
         
        ListNode res = head;
        if(left == 1) res = null;
        
        while(!stack.isEmpty()){
            ListNode node = stack.pop();
            
            if(res == null){
                start = node;
                res = start;
            }
            else{
                start.next = node;
                start = start.next;
            }
        }
        
        start.next = pos;
        
        return res;
    }
}
