class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        
        int[][] dp = new int[m + 1][n + 1];
        
        for(String str : strs){
            int numberOf0 = 0, numberOf1 = 0;
            for(int i = 0; i < str.length(); i++){
                if(str.charAt(i) == '0') numberOf0++;
            }
            
            numberOf1 = str.length() - numberOf0;
            
            for(int i = m - numberOf0; i > -1; i--){
                for(int j = n - numberOf1; j > -1; j--){
                    dp[i + numberOf0][j + numberOf1] = Math.max(dp[i + numberOf0][j + numberOf1], dp[i][j] + 1);
                }
            }
        }
        
        return dp[m][n];
    }
}
