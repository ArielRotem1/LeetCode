class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        
        for(int i = 1; i <= n; i++){
            while(nums[i - 1] != i && nums[i - 1] > 0 && nums[i - 1] <= n
                 && nums[i - 1] != nums[nums[i - 1] - 1]){
                int temp = nums[i - 1];
                nums[i - 1] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }
        
        int min = 1;
        
        for(int num : nums){
            if(num == min) min++;
            else break;
        }
        
        return min;
    }
}