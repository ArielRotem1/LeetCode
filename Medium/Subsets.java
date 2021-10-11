import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;

class Solution {
    private int[] nums;
    private HashSet<List<Integer>> result;
    private HashSet<Integer> currSet;
    
    public List<List<Integer>> subsets(int[] numbers) {
        nums = numbers;
        result = new HashSet();
        currSet = new HashSet();
        
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
        
        for(int num : nums){
            if(!currSet.contains(num)){
                currSet.add(num);
                DFS();
                currSet.remove(num);
            }
        }
    }
}
