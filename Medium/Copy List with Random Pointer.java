/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

import java.util.List;
import java.util.ArrayList;
import java.util.Hashtable;

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        
        List<Node> list = new ArrayList<>();
        Hashtable<Node, Integer> ht = new Hashtable<>();
        
        Node pos = head; 
        
        while(pos != null){
            list.add(new Node(pos.val));
            ht.put(pos, list.size() - 1);
            pos = pos.next;
        }
        
        pos = head;
        
        int index = 0;
        
        while(pos != null){
            Node currentNode = list.get(index);
            
            //setting the next
            if(pos.next != null) currentNode.next = list.get(index + 1);
            else currentNode.next = null;
            
            //setting the random
            Node random = pos.random;
            if(random == null) currentNode.random = null;
            else{
                int indexOfRandomInList = ht.get(random);
                currentNode.random = list.get(indexOfRandomInList);
            }
            
            index++;
            pos = pos.next;
        }
        
        return list.get(0);
    }
}
