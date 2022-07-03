class Solution {
    public int orangesRotting(int[][] grid) {
        
        //Time: O(m * n)
        //Space: O(m * n)
        
        int height = grid.length;
        int width = grid[0].length;
        
        int minutes = 0;
        
        int numberOfFreshOranges = 0;
        Queue<Integer> que = new ArrayDeque<>();
        
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                if(grid[i][j] == 1) numberOfFreshOranges++;
                else if(grid[i][j] == 2){
                    que.add(i);
                    que.add(j);
                }
            }   
        }
        
        while(!que.isEmpty() && numberOfFreshOranges > 0){
            
            Queue<Integer> nextDepth = new ArrayDeque<>();
            
            while(!que.isEmpty()){
                int i = que.poll();
                int j = que.poll();
                
                //up
                if(i - 1 > -1 && grid[i - 1][j] == 1){
                    grid[i - 1][j] = 2;
                    nextDepth.add(i - 1);
                    nextDepth.add(j);
                    numberOfFreshOranges--;
                }
                
                //down
                if(i + 1 < height && grid[i + 1][j] == 1){
                    grid[i + 1][j] = 2;
                    nextDepth.add(i + 1);
                    nextDepth.add(j);
                    numberOfFreshOranges--;
                }
                
                //left
                if(j - 1 > -1 && grid[i][j - 1] == 1){
                    grid[i][j - 1] = 2;
                    nextDepth.add(i);
                    nextDepth.add(j - 1);
                    numberOfFreshOranges--;
                }
                
                //right
                if(j + 1 < width && grid[i][j + 1] == 1){
                    grid[i][j + 1] = 2;
                    nextDepth.add(i);
                    nextDepth.add(j + 1);
                    numberOfFreshOranges--;
                }
            }
            
            que = nextDepth;
            minutes++;
        }
        
        return numberOfFreshOranges > 0 ? -1 : minutes;
    }
}
