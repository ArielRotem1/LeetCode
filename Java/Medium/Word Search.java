//Time: O(n*m * 3^L) - n: board height, m: board width, L: word.length
//Space: O(L)
class Solution {
    public boolean exist(char[][] board, String word) {
        
        char[] wordChars = word.toCharArray();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(exist(board, wordChars, 0, i, j)) return true;
            }    
        }
        
        return false;
    }
    
    private boolean exist(char[][] board, char[] word, int index, int i, int j) {
        
        if(i == -1 || i == board.length || j == -1 || j == board[0].length) return false;
        if(board[i][j] != word[index]) return false;
        
        if(index == word.length - 1) return true;
        
        
        board[i][j] = '.';
        index++;
        
        if(exist(board, word, index, i - 1, j) || 
            exist(board, word, index, i + 1, j) || 
            exist(board, word, index, i, j - 1) || 
            exist(board, word, index, i, j + 1)) return true;
        
        board[i][j] = word[index - 1];
        
        return false;
    }
}
