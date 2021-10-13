import java.util.*;

class Solution {
    public static int n;
    public static int m;
    public static int goal;
    public static int[][] matrix;
    public static Integer[][] dp;


    public int minimizeTheDifference(int[][] mat, int target) {
        goal = target;
        matrix = mat;
        n = matrix.length;
        m = matrix[0].length;
        
        dp = new Integer[n][5001];

        return solve(0, 0);
    }
    
    public int solve(int row, int sum){
        if(row == n){
            return Math.abs(sum - goal);
        }
        
        if(dp[row][sum] != null){
            return dp[row][sum];
        }
        
        int res = Integer.MAX_VALUE;
        for(int col = 0; col < m; col++){
            res = Math.min(res, solve(row + 1, sum + matrix[row][col]));
        }
        
        return dp[row][sum] = res;
    }
}
