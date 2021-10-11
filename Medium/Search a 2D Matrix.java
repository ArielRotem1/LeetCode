class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0, right = m * n - 1;
        while(left <= right){
            int middle = left + (int)Math.floor((right - left) / 2);
            
            int col = middle % n;
            int row = (int)Math.floor(middle / n);
            
            
            if(matrix[row][col] < target){
                left = middle + 1;
            }
            else if(matrix[row][col] > target){
                right = middle - 1;
            }
            else return true;
        }
        
        return false;
    }
}
