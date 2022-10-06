//n: number of elements in the list of a given key
//k: number of keys in the map

//Time: init - O(1)
//      set - O(1)
//      get - O(log(n))

//Space: O(k*n)


class StringAndIntegerLists{
    List<String> stringList;
    List<Integer> integerList;
    
    public StringAndIntegerLists(){
        stringList = new ArrayList<>();
        integerList = new ArrayList<>();
    }
}

class TimeMap {
    
    Map<String, StringAndIntegerLists> map;

    //O(1)
    public TimeMap() {
        map = new HashMap<>();
    }

    //O(1)
    public void set(String key, String value, int timestamp) {

        if(!map.containsKey(key)) map.put(key, new StringAndIntegerLists());
        
        StringAndIntegerLists lists = map.get(key);
        lists.stringList.add(value);
        lists.integerList.add(timestamp);
    }
    
    //O(log(n)) - n: number of elements in list
    public String get(String key, int timestamp) {
        StringAndIntegerLists lists = map.get(key);
        
        if(lists == null) return "";
        
        int left = 0, right = lists.integerList.size() - 1;
        int closestTimeIndex = -1;
        
        while(left <= right){
            int middle = (right - left) / 2 + left;
            
            int time = lists.integerList.get(middle);
            
            if(time > timestamp){
                right = middle - 1;
            }
            else if(time < timestamp){
                closestTimeIndex = middle;
                left = middle + 1;
            }
            else return lists.stringList.get(middle);
        }
        
        if(closestTimeIndex != -1){
            return lists.stringList.get(closestTimeIndex);
        }
        
        return "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
