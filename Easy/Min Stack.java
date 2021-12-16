class MinStack {
    
    Stack<Integer> minVal;
    Stack<Integer> stack;

    public MinStack() {
        minVal = new Stack();
        stack = new Stack();
    }
    
    public void push(int val) {
        try{
            int top = minVal.peek();
            if(val < top){
                minVal.push(val);
            }
            else{
                minVal.push(top);
            }
        }
        catch(Exception e){
            minVal.push(val);
        }
        finally{
            stack.push(val);
        }
    }
    
    public void pop() {
        stack.pop();
        minVal.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minVal.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */