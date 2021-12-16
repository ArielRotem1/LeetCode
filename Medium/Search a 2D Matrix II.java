class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int col = matrix[0].length - 1, row = 0;
        
        while(col > -1 && row < matrix.length){
            if(matrix[row][col] < target){
                row++;
            }
            else if(matrix[row][col] > target){
                col--;
            }
            else{
                return true;
            }
        }
        
        return false;
    }
}