
import java.util.Stack;

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed.length == 1) return true;
        
        return solve(0, 0, pushed, popped, new Stack<>());
    }
    
    private boolean solve(int indexPushed, int indexPopped, int[] pushed, int[] popped, Stack<Integer> stack){
        //check if can pop
        if(indexPopped < popped.length && stack.isEmpty() == false && stack.peek() == popped[indexPopped]){
            //if yes then pop and indexPopped + 1
            stack.pop();
            indexPopped++;
        }
        else{ //if not then check if you can push
            if(indexPushed < pushed.length){
                //if you can push then push and indexPushed + 1
                stack.push(pushed[indexPushed]);
                indexPushed++;
            }
            else{
                //if you finish the pop and push list then return true;
                if(indexPushed == pushed.length && indexPopped == popped.length){
                    return true;
                }
                //if you can't push or pop then return false;
                else return false;
            }
        }
        
        return solve(indexPushed, indexPopped, pushed, popped, stack);
    }
}
