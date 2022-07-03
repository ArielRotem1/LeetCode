class Solution {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length == 1) return nums.length;
        if(nums.length == 2) return nums[0] == nums[1] ? 1 : 2;
        
        int lastNum = nums[1];
        int lastDiff = nums[1] - nums[0];

        int numberOfElemsToRemove = lastDiff == 0 ? 1 : 0;

        for(int i = 2; i < nums.length; i++){
            int diff = nums[i] - lastNum;
            if((lastDiff == 0 && diff != 0) || diff * lastDiff < 0) lastDiff = diff;
            else numberOfElemsToRemove++;
            
            lastNum = nums[i];
        }
        
        
        return nums.length - numberOfElemsToRemove;
    }
}
