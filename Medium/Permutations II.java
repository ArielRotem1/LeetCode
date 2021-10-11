import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Hashtable;

class Solution {
    private HashSet<List<Integer>> result;
    private List<Integer> perm;
    private int[] nums;
    private Hashtable<Integer,Integer> ht;
    
    public List<List<Integer>> permuteUnique(int[] numbers) {
        
        ht = new Hashtable();
        nums = numbers;
        result = new HashSet();
        perm = new ArrayList(nums.length);
        
        for(int num : nums){
            if(ht.containsKey(num)){
                ht.put(num, ht.get(num) + 1);
            }
            else{
                ht.put(num, 1);
            }
        }
        
        DFS();
        
        return new ArrayList(result);
    }
    
    private void DFS(){
        
        // System.out.println();
        // System.out.println("perm: ");
        // System.out.println(Arrays.toString(perm.toArray()));
        // System.out.println();
        
        
        if(perm.size() == nums.length){
            if(result.contains(perm)) return;

            result.add(new ArrayList(perm));
            return;
        }
        
        Set<Integer> setOfKeys = ht.keySet();
 
        for (Integer key : setOfKeys) {
            if(ht.get(key) > 0){
                perm.add(key);
                ht.put(key, ht.get(key) - 1);
                DFS();
                ht.put(key, ht.get(key) + 1);
                perm.remove(perm.size() - 1);
            }
        }
    }
}
