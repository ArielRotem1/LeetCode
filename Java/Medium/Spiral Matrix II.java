class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        
        int value = 1;
        int maxNumber = n*n;
        int dir = 0;
        
        int col = 0;
        int row = 0;
        
        int minRow = 0, maxRow = n, minCol = -1, maxCol = n;
        
        
        while(value <= maxNumber){
            
            
            
            matrix[row][col] = value;
            
            // System.out.println();
            // System.out.println("row: " + row);
            // System.out.println("col: " + col);
            // System.out.println("minRow: " + minRow);
            // System.out.println("maxRow: " + maxRow);
            // System.out.println("minCol: " + minCol);
            // System.out.println("maxCol: " + maxCol);
            // System.out.println("dir: " + dir);
            // System.out.println("value: " + value);
            // System.out.println();
            
            if(dir == 0){
                col++;
                if(col == maxCol){
                    maxCol--;
                    col--;
                    dir = 1;
                    row++;
                }
            }
            
            else if(dir == 1){
                row++;
                if(row == maxRow){
                    maxRow--;
                    row--;
                    dir = 2;
                    col--;
                }
            }
            
            else if(dir == 2){
                col--;
                if(col == minCol){
                    minCol++;
                    col++;
                    dir = 3;
                    row--;
                }
            }
            
            else if(dir == 3){
                row--;
                if(row == minRow){
                    minRow++;
                    col++;
                    dir = 0;
                    row++;
                }
            }

            
            value++;
        }
        
        return matrix;
    }
}