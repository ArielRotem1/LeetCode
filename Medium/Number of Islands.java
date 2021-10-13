import java.util.*;
class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int mone = 0;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    mone++;
                    Queue<Integer> que = new ArrayDeque<>();
                    que.add(i);
                    que.add(j);
                    
                    
                    while(que.peek() != null){
                        int tempi = que.remove();
                        int tempj = que.remove();
                        
                        //up
                        if(tempi - 1 > -1 && grid[tempi - 1][tempj] == '1'){
                            que.add(tempi - 1);
                            que.add(tempj);
                            grid[tempi - 1][tempj] = '0';
                        }
                        
                        //down
                        if(tempi + 1 < m && grid[tempi + 1][tempj] == '1'){
                            que.add(tempi + 1);
                            que.add(tempj);
                            grid[tempi + 1][tempj] = '0';
                        }
                        
                        //left
                        if(tempj - 1 > -1 && grid[tempi][tempj - 1] == '1'){
                            que.add(tempi);
                            que.add(tempj - 1);
                            grid[tempi][tempj - 1] = '0';
                        }
                        
                        //right
                        if(tempj + 1 < n && grid[tempi][tempj + 1] == '1'){
                            que.add(tempi);
                            que.add(tempj + 1);
                            grid[tempi][tempj + 1] = '0';
                        }
                    }
                }
            }
        }
        
        
        return mone;
    }
}
