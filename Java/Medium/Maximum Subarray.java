class Solution {
    //Time: O(n) - n: nums.length
    //Space: O(1)
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE, left = 0, currSum = 0;

        for(int i = 0; i < nums.length; i++){
            currSum += nums[i];
            maxSum = Math.max(maxSum, currSum);
            while(currSum < 0){
                currSum -= nums[left];
                left++;
            }
        }

        return maxSum;
    }
}
