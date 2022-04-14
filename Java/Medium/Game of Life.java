class Solution {
    public void gameOfLife(int[][] board) {
        
        //Time: O(2*n) = O(n)
        //Space: O(1)
        
        int height = board.length, width = board[0].length;
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                board[i][j] += countNeighbors(i, j, board, height, width) * 10;
            } 
        }
        
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                int numberOfNeighbors = board[i][j] / 10;
                if(board[i][j] % 10 == 0){  //is dead cell
                    if(numberOfNeighbors == 3) board[i][j] = 1;
                    else board[i][j] = 0;
                }
                else{ //live cell
                    if(numberOfNeighbors < 2) board[i][j] = 0;
                    else if(numberOfNeighbors == 2 || numberOfNeighbors == 3) board[i][j] = 1;
                    else board[i][j] = 0;
                }
            } 
        }
    }
    
    private int countNeighbors(int i, int j, int[][] board, int height, int width){
        int count = 0;
        //up
        if(i - 1 > -1 && board[i - 1][j] % 10 == 1) count++;
        //down
        if(i + 1 < height && board[i + 1][j] % 10 == 1) count++;
        //left
        if(j - 1 > -1 && board[i][j - 1] % 10 == 1) count++;
        //right
        if(j + 1 < width && board[i][j + 1] % 10 == 1) count++;
        //up-left
        if(i - 1 > -1 && j - 1 > -1 && board[i - 1][j - 1] % 10 == 1) count++;
        //up-right
        if(i - 1 > -1 && j + 1 < width && board[i - 1][j + 1] % 10 == 1) count++;
        //down-left
        if(i + 1 < height && j - 1 > -1 && board[i + 1][j - 1] % 10 == 1) count++;
        //down-right
        if(i + 1 < height && j + 1 < width && board[i + 1][j + 1] % 10 == 1) count++;
        
        return count;
    }
}
