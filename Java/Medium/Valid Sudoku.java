class Solution {
    //Time: O(n * n) - n: board.length
    //Space: O(1)
    public boolean isValidSudoku(char[][] board) {
        int length = board.length;

        int nums = 0;
        
        //go on each row
        for(int i = 0; i < length; i++){
            for(int j = 0; j < length; j++){
                char c = board[i][j];
                if(c == '.') continue;
                int num = c - '0';
                if(!isAvaliable(nums, num)) return false;
                nums = markNum(nums, num);
            }
            
            nums = 0;
        }
        
        
        //go on each col
        for(int i = 0; i < length; i++){
            for(int j = 0; j < length; j++){
                char c = board[j][i];
                if(c == '.') continue;
                int num = c - '0';
                if(!isAvaliable(nums, num)) return false;
                nums = markNum(nums, num);
            }
            
            nums = 0;
        }
        
        int lengthDiv3 = length / 3;
        
        //go on each sub-box
        for(int i = 0; i < lengthDiv3; i++){
            for(int j = 0; j < lengthDiv3; j++){
                for(int k = 0; k < length; k++){
                    int col = j * 3 + k % (lengthDiv3);
                    int row = i * 3 + k / (lengthDiv3);
                    
                    
                    char c = board[row][col];
                    if(c == '.') continue;
                    
                    int num = c - '0';
                    if(!isAvaliable(nums, num)) return false;
                    nums = markNum(nums, num);
                }
                
                nums = 0;
            }
        }
        
        return true;
    }
    
    private boolean isAvaliable(int nums, int num){
        int bit = (nums >> num) & 1;
        return bit == 0;
    }
    
    private int markNum(int nums, int num){
        return nums | (1 << num);
    }
}
