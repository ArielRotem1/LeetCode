class Solution {
    boolean memo[][];
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        
        for(int num : nums) sum += num;
        
        if(sum % 2 != 0) return false;
        
        sum /= 2;
        
        memo = new boolean[n + 1][sum + 1];
        
        return subsetSum(nums, 0, sum);
    }
    
    boolean subsetSum(int[] nums, int pos, int sum){
        if(sum == 0) return true;
        if(pos == nums.length || sum < 0 || memo[pos][sum]) return false;
        
        if(subsetSum(nums, pos + 1, sum - nums[pos]) || subsetSum(nums, pos + 1, 
            sum)) return true;
        
        memo[pos][sum] = true;
        
        return false;
    }
}