import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

class Solution {
    private int[] nums;
    private HashSet<List<Integer>> result;
    private List<Integer> currSet;
    private Hashtable<Integer,Integer> ht;
    
    public List<List<Integer>> subsetsWithDup(int[] numbers) {
        nums = numbers;
        ht = new Hashtable();
        result = new HashSet();
        currSet = new ArrayList();
        
        for(int num : nums){
            if(ht.containsKey(num)){
                ht.put(num, ht.get(num) + 1);
            }
            else{
                ht.put(num, 1);
            }
        }
        
        DFS();
        
        return new ArrayList<>(result);
    }
    
    private void DFS(){
        
        if(currSet.size() > nums.length){
            return;
        }
        
        List<Integer> sortedList = new ArrayList<>(currSet);
        Collections.sort(sortedList);
        
        if(result.contains(sortedList)) return;
        
        result.add(sortedList);
        
        Set<Integer> setOfKeys = ht.keySet();
 
        for (Integer key : setOfKeys) {
            if(ht.get(key) > 0){
                currSet.add(key);
                ht.put(key, ht.get(key) - 1);
                DFS();
                ht.put(key, ht.get(key) + 1);
                currSet.remove(key);
            }
        }
    }
}
