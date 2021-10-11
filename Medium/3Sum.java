import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);
        
        List<List<Integer>> li = new ArrayList<List<Integer>>();
        
        for(int i = 0; i < nums.length - 2; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            
            int subSum = -1 * nums[i];
            
            int left = i + 1;
            int right = nums.length - 1;
            
            while(left < right){
                int sum = nums[left] + nums[right];
                if(sum == subSum){
                    li.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    while(left + 1 < right && nums[left] == nums[left + 1]) left++;
                    while(left < right - 1 && nums[right] == nums[right - 1]) right--;
                    
                    left++;
                    right--;
                }
                else{
                    if(sum < subSum){
                        left++;
                    }
                    else{ // sum > subSum
                        right--;
                    }
                }
            }
        }
        
        return li;
    }
}
