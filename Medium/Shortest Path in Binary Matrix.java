import java.util.*;

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1) return -1;
        
        int n = grid.length;
        int[][] dp = new int[n][n];
        
        Queue<Integer> que = new ArrayDeque<>();
        que.add(0);
        que.add(0);
        
        while(!que.isEmpty()){
            int i = que.remove();
            int j = que.remove();
            
            //right
            if(j + 1 < n && grid[i][j + 1] == 0){
                if(dp[i][j + 1] != 0){
                    if(dp[i][j] + 1 < dp[i][j + 1]){
                        que.add(i);
                        que.add(j + 1);
                        dp[i][j + 1] = dp[i][j] + 1;
                    }
                }
                else{
                    que.add(i);
                    que.add(j + 1);
                    dp[i][j + 1] = dp[i][j] + 1;
                }
            }
            
            //left
            if(j - 1 > -1 && grid[i][j - 1] == 0){
                if(dp[i][j - 1] != 0){
                    if(dp[i][j] + 1 < dp[i][j - 1]){
                        que.add(i);
                        que.add(j - 1);
                        dp[i][j - 1] = dp[i][j] + 1;
                    }
                }
                else{
                    que.add(i);
                    que.add(j - 1);
                    dp[i][j - 1] = dp[i][j] + 1;
                }
            }

            //down
            if(i + 1 < n && grid[i + 1][j] == 0){
                
                if(dp[i + 1][j] != 0){
                    if(dp[i][j] + 1 < dp[i + 1][j]){
                        que.add(i + 1);
                        que.add(j);
                        dp[i + 1][j] = dp[i][j] + 1;
                    }
                }
                else{
                    que.add(i + 1);
                    que.add(j);
                    dp[i + 1][j] = dp[i][j] + 1;
                }
            }
            
             //up
            if(i - 1 > -1 && grid[i - 1][j] == 0){
                
                if(dp[i - 1][j] != 0){
                    if(dp[i][j] + 1 < dp[i - 1][j]){
                        que.add(i - 1);
                        que.add(j);
                        dp[i - 1][j] = dp[i][j] + 1;
                    }
                }
                else{
                    que.add(i - 1);
                    que.add(j);
                    dp[i - 1][j] = dp[i][j] + 1;
                }
            }

            //down and right
            if(j + 1 < n && i + 1 < n && grid[i + 1][j + 1] == 0){
                
                if(dp[i + 1][j + 1] != 0){
                    if(dp[i][j] + 1 < dp[i + 1][j + 1]){
                        que.add(i + 1);
                        que.add(j + 1);
                        dp[i + 1][j + 1] = dp[i][j] + 1;
                    }
                }
                else{
                    que.add(i + 1);
                    que.add(j + 1);
                        dp[i + 1][j + 1] = dp[i][j] + 1;
                }
            }
            
            //down and left
            if(j - 1 > -1 && i + 1 < n && grid[i + 1][j - 1] == 0){
                
                if(dp[i + 1][j - 1] != 0){
                    if(dp[i][j] + 1 < dp[i + 1][j - 1]){
                        que.add(i + 1);
                        que.add(j - 1);
                        dp[i + 1][j - 1] = dp[i][j] + 1;
                    }
                }
                else{
                    que.add(i + 1);
                que.add(j - 1);
                    dp[i + 1][j - 1] = dp[i][j] + 1;
                }
            }
            
            //up and right
            if(j + 1 < n && i - 1 > -1 && grid[i - 1][j + 1] == 0){
                
                if(dp[i - 1][j + 1] != 0){
                    if(dp[i][j] + 1 < dp[i - 1][j + 1]){
                        que.add(i - 1);
                        que.add(j + 1);
                        dp[i - 1][j + 1] = dp[i][j] + 1;
                    }
                }
                else{
                    que.add(i - 1);
                    que.add(j + 1);
                    dp[i - 1][j + 1] = dp[i][j] + 1;
                }
            }
            
            //up and left
            if(j - 1 > -1 && i - 1 > -1 && grid[i - 1][j - 1] == 0){
                
                if(dp[i - 1][j - 1] != 0){
                    if(dp[i][j] + 1 < dp[i - 1][j - 1]){
                        que.add(i - 1);
                        que.add(j - 1);
                        dp[i - 1][j - 1] = dp[i][j] + 1;
                    }
                }
                else{
                    que.add(i - 1);
                    que.add(j - 1);
                    dp[i - 1][j - 1] = dp[i][j] + 1;
                }
            }
        }
        
        if(n != 1 && dp[n - 1][n - 1] == 0){
            return -1;
        }
        
        return dp[n - 1][n - 1] + 1;
    }
}
