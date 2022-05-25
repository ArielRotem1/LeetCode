class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        
        int[][] dp = new int[matrix.length][matrix[0].length];
        
        int longestPath = 1;
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                longestPath = Math.max(longestPath, DFS(matrix, i, j, dp));
            }
        }
        
        return longestPath;
    }
    
    private int DFS(int[][] matrix, int i, int j, int[][] dp){
        if(dp[i][j] != 0) return dp[i][j];
        
        int longestPath = 1;
        
        //top
        if(i - 1 > -1 && matrix[i - 1][j] > matrix[i][j]){
            longestPath = Math.max(longestPath, DFS(matrix, i - 1, j, dp) + 1);
        }

        //down
        if(i + 1 < matrix.length && matrix[i + 1][j] > matrix[i][j]){
            longestPath = Math.max(longestPath, DFS(matrix, i + 1, j, dp) + 1);
        }

        //left
        if(j - 1 > -1 && matrix[i][j - 1] > matrix[i][j]){
            longestPath = Math.max(longestPath, DFS(matrix, i, j - 1, dp) + 1);
        }

        //right
        if(j + 1 < matrix[0].length && matrix[i][j + 1] > matrix[i][j]){
            longestPath = Math.max(longestPath, DFS(matrix, i, j + 1, dp) + 1);
        }
        
        dp[i][j] = longestPath;
        return longestPath;
    }
}























