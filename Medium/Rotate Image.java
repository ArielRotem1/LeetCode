class Solution {
    public void rotate(int[][] matrix) {
        for(int currLoc = 0; currLoc < Math.floor(matrix.length / 2); currLoc++){
            for(int i = 0; i < matrix.length - (currLoc * 2) - 1; i++){
                rotate(1, matrix.length - (currLoc * 2) - 1, matrix[currLoc][currLoc], currLoc, currLoc + 1, currLoc, currLoc, matrix);
            }
        }
    }
    
    private void rotate(int counter, int size, int currVal, int row, int col, int startRow, int startCol, int[][] matrix){
        
        int temp = matrix[row][col];
        matrix[row][col] = currVal;
        
        if(row == startRow && col == startCol) return;

        //left
        if(counter / size == 0){
            col++;
        }

        //down
        else if(counter / size == 1){
            row++;
        }
        
        //right
        else if(counter / size == 2){
            col--;
        }
        
        //up
        else if(counter / size == 3){
            row--;
        }
        
        rotate(counter + 1, size, temp, row, col, startRow, startCol, matrix);
    }
}