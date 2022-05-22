class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int height = obstacleGrid.length;
        int width = obstacleGrid[0].length;
        
        if(height == 1 && width == 1 && obstacleGrid[0][0] == 1) return 0;
        
        int[][] memo = new int[height][width];
        memo[0][0] = 1;
        
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                if(obstacleGrid[i][j] == 1) continue;
                //right
                if(j + 1 < width && obstacleGrid[i][j + 1] == 0) memo[i][j + 1] += memo[i][j];
                //down
                if(i + 1 < height && obstacleGrid[i + 1][j] == 0) memo[i + 1][j] += memo[i][j];
            }
        }
        
        return memo[height - 1][width - 1];
    }
}
