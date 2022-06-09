import java.util.Hashtable;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Hashtable<Integer, Integer> ht = new Hashtable<>();
        for(int i = 0; i < nums.length; i++){
            
            if(ht.containsKey(target - nums[i])){
                return new int[]{i, ht.get(target - nums[i])};
            }
            
            ht.put(nums[i], i);
        }
        return null;
    }
}
