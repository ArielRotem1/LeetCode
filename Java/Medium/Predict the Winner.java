//Time: O(n^2) - n: nums.length
//Space: O(n^2)
class Solution {
    public boolean PredictTheWinner(int[] nums) {
        if(nums.length == 1) return true;
        
        Integer[][] dp = new Integer[nums.length][nums.length];
        predictTheWinner(nums, 0, nums.length - 1, dp, 1);
        return dp[0][nums.length - 1] >= 0;
    }

    int predictTheWinner(int[] nums, int left, int right, Integer[][] dp, int op){

        if(left == right) return nums[left] * op; 

        if(dp[left][right] != null) return dp[left][right];

        //take the left
        int resultLeft = predictTheWinner(nums, left + 1, right, dp, op * -1) + nums[left] * op;

        //take the right
        int resultRight = predictTheWinner(nums, left, right - 1, dp, op * -1) + nums[right] * op;

        //player 2 turn
        if(op == -1) return dp[left][right] = Math.min(resultLeft, resultRight);
        //player 1 turn
        else return dp[left][right] = Math.max(resultLeft, resultRight);
    }
}
