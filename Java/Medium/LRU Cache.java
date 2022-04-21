import java.util.Hashtable;

class Node{
    
    int val;
    int key;
    Node next;
    Node prev;
    
    public Node(int val, int key, Node next){
        this.val = val;
        this.key = key;
        this.next = next;
        this.prev = null;
    }
}

class LRUCache {
    
    Hashtable<Integer, Node> hs;
    Node first;
    Node last;
    int currCapacity;
    int maxCapacity;

    public LRUCache(int capacity) {
        first = null;
        last = null;
        currCapacity = 0;
        maxCapacity = capacity;
        hs = new Hashtable<>();
    }
    
    public int get(int key) {
        Node nodeToGet = hs.get(key);
        if(nodeToGet == null) return -1;
        
        Node prev = nodeToGet.prev;
        if(prev == null) return nodeToGet.val; //the node to get is the first node
        
        nodeToGet.prev = null;

        Node next = nodeToGet.next;
        prev.next = next;
        if(next == null){ //the node to get is the last node
            last = prev;
            updateFirst(nodeToGet, false);
            return nodeToGet.val;
        }
        next.prev = prev;
        
        updateFirst(nodeToGet, false);
        
        return nodeToGet.val;
    }
    
    public void put(int key, int value) {
        if(!hs.containsKey(key) && currCapacity <= maxCapacity) currCapacity++;
        
        if(currCapacity > maxCapacity){
            currCapacity--;
            removeMostNotUsed();
        }
        
        Node node = hs.get(key);
        
        boolean changePos = true;
        
        if(node == null){
            node = new Node(value, key, first);
            changePos = false;
        }
        else node.val = value;
        
        hs.put(key, node);
        updateFirst(node, changePos);
    }
    
    private void updateFirst(Node node, boolean changePos){
        if(changePos){
            Node prev = node.prev;
            if(prev == null) return; //the node to get is the first node
            
            node.prev = null;

            Node next = node.next;
            prev.next = next;
            if(next == null){ //the node to get is the last node
                last = prev;
                updateFirst(node, false);
                return;
            }
            next.prev = prev;
            
            updateFirst(node, false);
        }
        else{
            if(first != null){
                first.prev = node;
                node.next = first;
            }
            else last = node;

            first = node;
        }
    }
    
    private void removeMostNotUsed(){
        
        hs.remove(last.key);
        
        Node prev = last.prev;
        if(prev == null){
            first = null;
            last = null;
            return;
        }
        
        prev.next = null;
        last = prev;
    }
}


