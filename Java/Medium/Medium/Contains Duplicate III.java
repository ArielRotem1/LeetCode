
class NumberAndIndex implements Comparable<NumberAndIndex> {
    public int index;
    public double value;
    
    public NumberAndIndex(int i, double v){
        index = i;
        value = v;
    }
    
    @Override
    public int compareTo(NumberAndIndex o) {
        if (value < o.value) return -1;
        else if (value > o.value) return 1;
        return 0;
    }
}


class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        
        if(k == 0 || nums.length == 0) return false;
        
        List<NumberAndIndex> list = new ArrayList<>();
        
        for(int i = 0; i < nums.length; i++){
            list.add(new NumberAndIndex(i, nums[i]));
        }
        
        Collections.sort(list);
        
        for(int i = 0; i < nums.length; i++){
            
            for(int j = i + 1; j < nums.length && Math.abs(list.get(i).value - list.get(j).value) <= t; j++){
                if(Math.abs(list.get(i).index - list.get(j).index) <= k) return true;
            }
        }
        
        return false;
    }
}
