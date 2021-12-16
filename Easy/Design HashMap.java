class MyHashMap {
    
    private ArrayList<ArrayList<Integer>> keysAndValues;

    public MyHashMap() {
        keysAndValues = new ArrayList<>();
    }
    
    public void put(int key, int value) {
        
        int keyHash = hash(key);
        
        try{
            ArrayList<Integer> IntegerList = keysAndValues.get(keyHash);
            for(int i = 0; i < IntegerList.size(); i+=2){
                if(key == IntegerList.get(i)){
                    IntegerList.set(i + 1, value);
                    return;
                }
            }

            IntegerList.add(key);
            IntegerList.add(value);
        }
        catch(Exception e){
            for(int i = keysAndValues.size(); i <= keyHash; i++){
                keysAndValues.add(new ArrayList<>());
            }
            
            ArrayList<Integer> IntegerList = keysAndValues.get(keyHash);
            IntegerList.add(key);
            IntegerList.add(value);
        }
    }
    
    public int get(int key) {
        
        int keyHash = hash(key);
        
        int result = -1;
        
        try{
            ArrayList<Integer> IntegerList = keysAndValues.get(keyHash);
            
            for(int i = 0; i < IntegerList.size(); i+=2){
                if(key == IntegerList.get(i)){
                    result = IntegerList.get(i + 1);
                    break;
                }
            }
        }
        catch(Exception ex){
            
        }

        return result;
    }
    
    public void remove(int key) {
        
        int keyHash = hash(key);
        
        try{
            ArrayList<Integer> IntegerList = keysAndValues.get(keyHash);
            
            for(int i = 0; i < IntegerList.size(); i+=2){
                if(key == IntegerList.get(i)){
                    IntegerList.remove(i + 1);
                    IntegerList.remove(i);
                }
            }
        }
        catch(Exception ex){
            
        }
    }
    
    private int hash(int key){
        return key % 1000;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */