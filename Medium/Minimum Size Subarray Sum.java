class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0, start = 0, end = 0, minLen = Integer.MAX_VALUE;
        while(end < nums.length){
            if(sum < target){
                sum += nums[end];
                end++;
            }
            
            while(sum >= target){
                minLen = Math.min(minLen, end - start);
                sum -= nums[start];
                start++;
            }
        }
        
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}