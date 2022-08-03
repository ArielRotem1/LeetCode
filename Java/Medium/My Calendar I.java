class Event{
    int start;
    int end;
    
    public Event(int start, int end){
        this.start = start;
        this.end = end;
    }
}

class MyCalendar {
    
    List<Event> events;

    //Space: O(n) -> n = events.size()
    public MyCalendar() {
        events = new ArrayList<>();
    }
    
    //Time: O(n) -> n = events.size()
    public boolean book(int start, int end) {
        
        int insertIndex = getInsertIndex(start, end);
        if(insertIndex == -1) return false;
        
        //Could take O(n) time
        events.add(insertIndex, new Event(start, end));
        return true;
    }
    
    //Time: O(log(n)) -> n = events.size()
    private int getInsertIndex(int start, int end){
        //binary search
        int left = 0, right = events.size() - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            
            Event midEvent = events.get(mid);
            
            if(midEvent.start >= end){
                right = mid - 1;
            }
            else if(midEvent.end <= start){
                left = mid + 1;
            }
            else return -1;
        }
        
        return left;
    }

}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
