class Solution {
    //Time: O(n^2)
    //Space: O(1)
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;

        int min = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        int numberOfMins = 0;

        //get the first min and numberOfMins
        //O(n)
        for(int j = 0; j < n; j++){
            if(min > grid[0][j]){
                numberOfMins = 1;
                min = grid[0][j];
            }
            else if(min == grid[0][j]) numberOfMins++;
        }


        for(int i = 1; i < n; i++){
            int nextMin = Integer.MAX_VALUE;

            if(numberOfMins > 1){
                numberOfMins = 0;
                for(int j = 0; j < n; j++){
                    grid[i][j] += min;
                    if(nextMin > grid[i][j]){
                        numberOfMins = 1;
                        nextMin = grid[i][j];
                    }
                    else if(nextMin == grid[i][j]) numberOfMins++;
                }

                min = nextMin;
                continue;
            }

            secondMin = Integer.MAX_VALUE;
            numberOfMins = 0;

            for(int j = 0; j < n; j++){
                if(grid[i - 1][j] == min) continue;
                secondMin = Math.min(secondMin, grid[i - 1][j]);
            }

            for(int j = 0; j < n; j++){
                if(grid[i - 1][j] > min) grid[i][j] += min;
                else grid[i][j] += secondMin;

                if(nextMin > grid[i][j]){
                    numberOfMins = 1;
                    nextMin = grid[i][j];
                }
                else if(nextMin == grid[i][j]) numberOfMins++;
            }

            min = nextMin;
        }

        return min;
    }
}
