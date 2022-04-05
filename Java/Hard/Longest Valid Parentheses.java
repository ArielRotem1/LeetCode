import java.util.Stack;

class Solution {
    public int longestValidParentheses(String s) {
        
        // Time: O(2*n) = O(n)
        // Space: O(2n) = O(n)
        
        int len = s.length();
        
        Stack<Integer> stack = new Stack();
        
        for(int i = 0; i < len; i++){
            
            if(s.charAt(i) == ')'){
                if(!stack.isEmpty()) stack.pop();
            }
            else stack.push(i);
        }
        
        Stack<Integer> reversedStack = new Stack();
        
        while(!stack.isEmpty()) reversedStack.push(stack.pop());
        
        
        int longestValidParentheses = 0, currValidParenthesesCount = 0, openParenthesesCount = 0;
        
        for(int i = 0; i < len; i++){
            
            if(s.charAt(i) == ')'){
                if(openParenthesesCount > 0){
                    currValidParenthesesCount += 2;
                    openParenthesesCount--;
                }
                else{
                    longestValidParentheses = Math.max(longestValidParentheses, currValidParenthesesCount);
                    currValidParenthesesCount = 0;
                }
            }
            else{
                if(!reversedStack.isEmpty() && reversedStack.peek() == i){
                    longestValidParentheses = Math.max(longestValidParentheses, currValidParenthesesCount);
                    currValidParenthesesCount = 0;
                    reversedStack.pop();
                }
                else openParenthesesCount++;
            }
        }
        
        longestValidParentheses = Math.max(longestValidParentheses, currValidParenthesesCount);
        
        return longestValidParentheses;
    }
}
