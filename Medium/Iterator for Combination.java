class CombinationIterator {
    
    private Stack<Integer> stack;
    private String chars;
    private int length;
    private int charsLength;

    public CombinationIterator(String characters, int combinationLength) {
        chars = characters;
        length = combinationLength;
        stack = new Stack<>();
        charsLength = chars.length();
        
        for(int i = 0; i < combinationLength; i++){
            stack.push(i);
        }
    }
    
    public String next() {
        String result = getNext();
        
        int currLength = length - 1;
        int lastIndex = stack.pop() + 1;
        
        
        while(currLength < length){
            
            if(lastIndex >= charsLength){
                if(stack.size() == 0) break;
                lastIndex = stack.pop() + 1;
                currLength--;
            }
            
            while(lastIndex < charsLength){
                stack.push(lastIndex);
                currLength++;
                lastIndex++;
                break;
            }
        }
        
        return result;
    }
    
    private String getNext(){
        String s = "";
        Stack<Integer> temp = new Stack<>();
        while(stack.size() != 0){
            temp.push(stack.pop());
        }
        
        while(temp.size() != 0){
            int x = temp.pop();
            s += chars.charAt(x);
            stack.push(x);
        }
        
        return s;
    }
    
    public boolean hasNext() {
        return stack.size() == length;
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */