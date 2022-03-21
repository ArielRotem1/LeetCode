class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        
        int closestSum = 0;
        int closestDiff = 3001;
        int len = nums.length;
        
        for(int index = 0; index < len - 2; index++){
            int left = index + 1;
            int right = len - 1;
            int currSum = nums[index] + nums[left] + nums[right];
            
            int bestDiff =  Math.abs(currSum - target);
            int bestSum = currSum;
            
            
            while(left < right){
                currSum = nums[index] + nums[left] + nums[right];
                
                if(bestDiff > Math.abs(currSum - target)){
                    bestDiff = Math.abs(currSum - target);
                    bestSum = currSum;
                }
                
                if(currSum < target)
                    left++;
                else if(currSum > target)
                    right--;
                else
                    return target;
            }
        
            if(bestDiff < closestDiff){
                closestDiff = bestDiff;
                closestSum = bestSum;
            }
        }
        
        return closestSum;
    }
}