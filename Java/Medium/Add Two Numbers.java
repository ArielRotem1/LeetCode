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
import java.util.*;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode((l1.val + l2.val) % 10);
        int add = (l1.val + l2.val) / 10;
        ListNode pos = result;
        
        l1 = l1.next;
        l2 = l2.next;
        
        while(l1 != null || l2 != null){
            
            int sum = add;
            
            if(l1 != null) sum += l1.val;
            if(l2 != null) sum += l2.val;

            pos.next = new ListNode(sum % 10);
            add = sum / 10;
            
            pos = pos.next;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        
        if(add != 0){
            pos.next = new ListNode(add);
        }
        
        return result;
    }
}
