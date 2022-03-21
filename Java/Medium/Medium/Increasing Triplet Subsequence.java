class Solution {
    public boolean increasingTriplet(int[] nums) {
        int minI = nums[0];
        int minJ = Integer.MAX_VALUE;
        
        for(int i = 1; i < nums.length; i++){
            if(minJ == Integer.MAX_VALUE){
                if(minI > nums[i]){
                    minI = nums[i];
                }
                else if(minI < nums[i]){
                    minJ = nums[i];
                }
            }
            else{
                if(minJ < nums[i]) return true;
                else if(minI < nums[i] && nums[i] < minJ){
                    minJ = nums[i];
                }
                else if(minI > nums[i] && i + 1 < nums.length && nums[i + 1] <= 
                    minJ && nums[i + 1] > nums[i]){
                    minI = nums[i];
                    minJ = nums[i + 1];
                }
            }
        }
        
        return false;
    }
}