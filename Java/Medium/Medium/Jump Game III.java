import java.util.HashSet;
class Solution {
    public boolean canReach(int[] arr, int start) {
        HashSet<Integer> indexesVisited = new HashSet();
        
        return solve(indexesVisited, arr, start);
    }
    
    private boolean solve(HashSet<Integer> indexesVisited, int[] arr, int index){
        if(indexesVisited.contains(index)) return false;
        if(index < 0 || index >= arr.length) return false;
        
        int val = arr[index];
        
        if(val == 0) return true;
        
        indexesVisited.add(index);
        
        return solve(indexesVisited, arr, index - val) || solve(indexesVisited, arr, 
            index + val);
    }
}