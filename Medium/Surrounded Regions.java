import java.util.Queue;

class Solution {
    public void solve(char[][] board) {
        int height = board.length;
        int width = board[0].length;
        
        //from up to down
        for(int i = 0; i < height; i++){
            
            if(board[i][0] == 'O'){
                Queue<Integer> que = new ArrayDeque<>();
                que.add(i);
                que.add(0);
                board[i][0] = '!';
                
                while(!que.isEmpty()){
                    int currI = que.remove();
                    int currJ = que.remove();
                    
                    //up
                    if(currI - 1 > -1 && board[currI - 1][currJ] == 'O'){
                        board[currI - 1][currJ] = '!';
                        que.add(currI - 1);
                        que.add(currJ);
                    }
                    
                    //down
                    if(currI + 1 < height && board[currI + 1][currJ] == 'O'){
                        board[currI + 1][currJ] = '!';
                        que.add(currI + 1);
                        que.add(currJ);
                    }
                    
                    //left
                    if(currJ - 1 > -1 && board[currI][currJ - 1] == 'O'){
                        board[currI][currJ - 1] = '!';
                        que.add(currI);
                        que.add(currJ - 1);
                    }
                    
                    //right
                    if(currJ + 1 < width && board[currI][currJ + 1] == 'O'){
                        board[currI][currJ + 1] = '!';
                        que.add(currI);
                        que.add(currJ + 1);
                    }
                }
            }
            
            if(board[i][width - 1] == 'O'){
                Queue<Integer> que = new ArrayDeque<>();
                que.add(i);
                que.add(width - 1);
                board[i][width - 1] = '!';
                
                while(!que.isEmpty()){
                    int currI = que.remove();
                    int currJ = que.remove();
                    
                    //up
                    if(currI - 1 > -1 && board[currI - 1][currJ] == 'O'){
                        board[currI - 1][currJ] = '!';
                        que.add(currI - 1);
                        que.add(currJ);
                    }
                    
                    //down
                    if(currI + 1 < height && board[currI + 1][currJ] == 'O'){
                        board[currI + 1][currJ] = '!';
                        que.add(currI + 1);
                        que.add(currJ);
                    }
                    
                    //left
                    if(currJ - 1 > -1 && board[currI][currJ - 1] == 'O'){
                        board[currI][currJ - 1] = '!';
                        que.add(currI);
                        que.add(currJ - 1);
                    }
                    
                    //right
                    if(currJ + 1 < width && board[currI][currJ + 1] == 'O'){
                        board[currI][currJ + 1] = '!';
                        que.add(currI);
                        que.add(currJ + 1);
                    }
                }
            }
        }
        
        
        
        //from left to right
        for(int j = 0; j < width; j++){
            
            if(board[0][j] == 'O'){
                Queue<Integer> que = new ArrayDeque<>();
                que.add(0);
                que.add(j);
                board[0][j] = '!';
                
                while(!que.isEmpty()){
                    int currI = que.remove();
                    int currJ = que.remove();
                    
                    //up
                    if(currI - 1 > -1 && board[currI - 1][currJ] == 'O'){
                        board[currI - 1][currJ] = '!';
                        que.add(currI - 1);
                        que.add(currJ);
                    }
                    
                    //down
                    if(currI + 1 < height && board[currI + 1][currJ] == 'O'){
                        board[currI + 1][currJ] = '!';
                        que.add(currI + 1);
                        que.add(currJ);
                    }
                    
                    //left
                    if(currJ - 1 > -1 && board[currI][currJ - 1] == 'O'){
                        board[currI][currJ - 1] = '!';
                        que.add(currI);
                        que.add(currJ - 1);
                    }
                    
                    //right
                    if(currJ + 1 < width && board[currI][currJ + 1] == 'O'){
                        board[currI][currJ + 1] = '!';
                        que.add(currI);
                        que.add(currJ + 1);
                    }
                }
            }
            
            if(board[height - 1][j] == 'O'){
                Queue<Integer> que = new ArrayDeque<>();
                que.add(height - 1);
                que.add(j);
                board[height - 1][j] = '!';
                
                while(!que.isEmpty()){
                    int currI = que.remove();
                    int currJ = que.remove();
                    
                    //up
                    if(currI - 1 > -1 && board[currI - 1][currJ] == 'O'){
                        board[currI - 1][currJ] = '!';
                        que.add(currI - 1);
                        que.add(currJ);
                    }
                    
                    //down
                    if(currI + 1 < height && board[currI + 1][currJ] == 'O'){
                        board[currI + 1][currJ] = '!';
                        que.add(currI + 1);
                        que.add(currJ);
                    }
                    
                    //left
                    if(currJ - 1 > -1 && board[currI][currJ - 1] == 'O'){
                        board[currI][currJ - 1] = '!';
                        que.add(currI);
                        que.add(currJ - 1);
                    }
                    
                    //right
                    if(currJ + 1 < width && board[currI][currJ + 1] == 'O'){
                        board[currI][currJ + 1] = '!';
                        que.add(currI);
                        que.add(currJ + 1);
                    }
                }
            }
        }
        
        
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                if(board[i][j] == 'O') board[i][j] = 'X';
                else if(board[i][j] == '!') board[i][j] = 'O';
            }
        }
    }
}
