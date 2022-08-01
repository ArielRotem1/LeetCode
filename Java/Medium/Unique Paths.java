class Solution {
    public int uniquePaths(int m, int n) {
        
        //Time: O(n*m)
        //Space: O(n*m)
        
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(dp[i][j] == 0) continue;
                
                if(j + 1 < n) dp[i][j + 1] += dp[i][j];
                if(i + 1 < m) dp[i + 1][j] += dp[i][j];
            }
        }
        
        return dp[m - 1][n - 1];
    }
}
