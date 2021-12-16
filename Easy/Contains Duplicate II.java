import java.util.HashSet;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> hs = new HashSet<>();
        int counter = 0;
        for(int i = 0; i < nums.length; i++){
            if(!hs.add(nums[i])) return true;
            
            counter++;
            
            if(counter > k){
                hs.remove(nums[i - k]);
                counter = 2;
            }
        }
        
        return false;
    }
}