//Approach 1 - DFS: 
//Time: O(2^n) - n: nums.length
//Space: O(n)

//Approach 2 - DP:
//Time: O(n^2)
//Space: O(n)

class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][2];
        for(int i = 0; i < n; i++){
            dp[i] = new int[]{1, 1};
        }

        int result = 0;
        int longestSeq = 0;

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(nums[i] >= nums[j]) continue;

                //new longest subsequence
                if(dp[i][0] + 1 > dp[j][0]){
                    dp[j][0] = dp[i][0] + 1;
                    dp[j][1] = dp[i][1];
                }
                //same length of sequence already
                else if(dp[i][0] + 1 == dp[j][0]){
                    dp[j][1] += dp[i][1];
                }
            }

            //new longest subsequence
            if(dp[i][0] > longestSeq){
                longestSeq = dp[i][0];
                result = dp[i][1];
            }
            else if(longestSeq == dp[i][0]){
                result += dp[i][1];
            }
        }

        return result;
    }
}
