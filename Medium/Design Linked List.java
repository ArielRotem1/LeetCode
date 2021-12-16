class MyLinkedList {
    
    public int val;
    private static MyLinkedList beginning;
    public MyLinkedList next = null;

    public MyLinkedList() {
        beginning = null;
    }
    
    public MyLinkedList(int val) {
        this.val = val;
    }
    
    public int get(int index) {
        MyLinkedList temp = beginning;
        while(index > 0){
            temp = temp.next;
            if(temp == null) return -1;
            index--;
        }
        
        if(temp == null) return -1;
        
        return temp.val;
    }
    
    public void addAtHead(int val) {
        MyLinkedList temp = new MyLinkedList(val);
        
        if(beginning == null){
            beginning = temp;
        }
        else{
            temp.next = beginning;
            beginning = temp;
        }
    }
    
    public void addAtTail(int val) {
        
        if(beginning == null){
            MyLinkedList temp = new MyLinkedList(val);
            
            beginning = temp;
            
            return;
        }
        
        MyLinkedList temp = beginning;
        
        while(temp.next != null){
            temp = temp.next;
        }
        
        temp.next = new MyLinkedList(val);
    }
    
    public void addAtIndex(int index, int val) {
        
        if(index == 0){
            addAtHead(val);
            return;
        }
        
        
        MyLinkedList temp = beginning;
        if(temp == null) return;
        while(index > 1){
            temp = temp.next;
            index--;
        }
        
        if(temp == null) return;
        
        MyLinkedList temp2 = temp.next;
        temp.next = new MyLinkedList(val);
        temp.next.next = temp2;
    }
    
    public void deleteAtIndex(int index) {
        
        if(beginning == null) return;
        
        MyLinkedList temp = beginning;
        
        if(index == 0){
            beginning = beginning.next;
            return;
        }
        
        while(index > 1){
            temp = temp.next;
            if(temp == null) return;
            index--;
        }
        
        if(temp.next == null) return;
        
        temp.next = temp.next.next;
    }
}



/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */