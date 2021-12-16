class Solution {
    public int lengthOfLIS(int[] nums) {
        Stack<Integer> stack = new Stack();
        Stack<Integer> returnStack = new Stack();
        
        //O(n)
        for(int x : nums){
            if(stack.isEmpty()) stack.push(x);
            else{
                
                int top = stack.peek();
                
                while(top > x){
                    int temp = stack.pop();
                    if(stack.isEmpty()){
                        break;
                    }
                    top = stack.peek();
                    
                    if(top < x){
                        break;
                    }
                    
                    returnStack.push(temp);
                }
                
                if(top != x)
                    stack.push(x);
                
                while(returnStack.isEmpty() == false) stack.push(returnStack.pop());
            }
        }
        
        return stack.size();
    }
}