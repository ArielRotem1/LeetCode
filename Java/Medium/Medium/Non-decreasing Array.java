class Solution {
    public boolean checkPossibility(int[] nums) {
        
        int counterIssues = 0;
        int leftMinNumber = Integer.MIN_VALUE;
        
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] > nums[i + 1]){
                counterIssues++;
                if(counterIssues > 1) return false;
                if(leftMinNumber <= nums[i + 1]){
                    nums[i] = nums[i + 1];
                }
                else{
                    nums[i + 1] = nums[i];
                }
            }
                
            
            leftMinNumber = Math.max(nums[i], leftMinNumber);
        }
        
        return true;
    }
}