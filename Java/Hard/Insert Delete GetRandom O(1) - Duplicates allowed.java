
//Space: O(n) - n: number of numbers entered\
//Time: O(1)
class RandomizedCollection {
    
    Map<Integer, HashSet<Integer>> indexToNum;
    ArrayList<Integer> nums;

    public RandomizedCollection() {
        indexToNum = new HashMap<>();
        nums = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        boolean present = indexToNum.containsKey(val);
        if(!present) indexToNum.put(val, new HashSet<>());
        
        indexToNum.get(val).add(nums.size());
        nums.add(val);
        return !present;
    }
    
    public boolean remove(int val) {
        if(!indexToNum.containsKey(val)) return false;

        HashSet hs = indexToNum.get(val);
        Integer index = (Integer)hs.iterator().next();
        hs.remove(index);
        int lastIndex = nums.size() - 1;
        if(lastIndex != index){ //if not in end of list
            int valToReplace = nums.get(lastIndex);
            indexToNum.get(valToReplace).remove(lastIndex);
            nums.set(index, valToReplace);
            indexToNum.get(valToReplace).add(index);
        }           
        
        if(indexToNum.get(val).isEmpty()) indexToNum.remove(val);
        
        nums.remove(lastIndex);
        return true;
    }
    
    public int getRandom() {
        return nums.get((int)Math.floor(Math.random() * nums.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
