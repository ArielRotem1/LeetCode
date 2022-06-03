


class NumMatrix {
    
    int[][] sumMatrix;

    //n = matrix.length
    //m = matrix[0].length
    
    //Time: O(n*m)
    //Space: O(n*m)
    public NumMatrix(int[][] matrix) {
        
        int n = matrix.length;
        int m = matrix[0].length;
        
        for(int i = 1; i < n; i++){
            matrix[i][0] += matrix[i - 1][0];
        }
        
        for(int i = 1; i < m; i++){
            matrix[0][i] += matrix[0][i - 1];
        }
        
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                matrix[i][j] += matrix[i][j - 1] + matrix[i - 1][j] - matrix[i - 1][j - 1];
            }
        }
        
        sumMatrix = matrix;
    }
    
    //Time: O(1)
    //Space: O(1)
    /*
    0 <= row1 <= row2 < m
    0 <= col1 <= col2 < n
    */
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = sumMatrix[row2][col2];
        
        if(col1 > 0) res -= sumMatrix[row2][col1 - 1];
        if(row1 > 0) res -= sumMatrix[row1 - 1][col2];
        
        if(row1 > 0 && col1 > 0) res += sumMatrix[row1 - 1][col1 - 1];
        
        return res;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
