class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length < 3) return 0;
        
        int answer = 0;
        
        int counter = 0;
        
        int diff = nums[1] - nums[0];
        
        for(int i = 2; i < nums.length; i++){
            if(diff == nums[i] - nums[i - 1]){
                counter++;
                answer += counter;
            }
            else{
                counter = 0;
                diff = nums[i] - nums[i - 1];
            }
        }
        
        return answer;
    }
}
