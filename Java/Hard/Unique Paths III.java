class Solution {
    
    private int waysToGo;
    private int[][] grid;
    private int height;
    private int width;
    private int nonObstacleCount;
    
    public int uniquePathsIII(int[][] grid) {
        
        this.grid = grid;
        waysToGo = 0;
        nonObstacleCount = 0;
        
        height = grid.length;
        width = grid[0].length;
        
        int iStart = -1, jStart = -1;
        int[] endPos = new int[2];
        
        boolean[][] visited = new boolean[height][width];
        
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                if(grid[i][j] == 1){
                    iStart = i;
                    jStart = j;
                    nonObstacleCount++;
                }
                else if(grid[i][j] == 2){
                    endPos[0] = i;
                    endPos[1] = j;
                    nonObstacleCount++;
                }
                else if(grid[i][j] == -1){
                    visited[i][j] = true;
                }
                else{
                    nonObstacleCount++;
                }
            }
        }
        
        solve(iStart, jStart, endPos, visited, 1);
        
        return waysToGo;
    }
    
    private void solve(int i, int j, int[] endPos, boolean[][] visited, int moves){
        
        visited[i][j] = true;
        
        if(i == endPos[0] && j == endPos[1] && nonObstacleCount == moves){
            waysToGo++;
            visited[i][j] = false;
            return;
        }
        
        //down
        if(i + 1 < height && !visited[i + 1][j]){
            solve(i + 1, j, endPos, visited, moves + 1);
        }
        //up
        if(i - 1 > -1 && !visited[i - 1][j]){
            solve(i - 1, j, endPos, visited, moves + 1);
        }
        //right
        if(j + 1 < width && !visited[i][j + 1]){
            solve(i, j + 1, endPos, visited, moves + 1);
        }
        //left
        if(j - 1 > -1 && !visited[i][j - 1]){
            solve(i, j - 1, endPos, visited, moves + 1);
        }
        
        visited[i][j] = false;
    }
}
