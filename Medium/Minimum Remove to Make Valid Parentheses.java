class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> indicsOfParentheses = new Stack();
        
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        
        int reduce = 0;
        
        for(int i = 0; i < chars.length; i++){
            boolean add = true;
            if(chars[i] == '('){
                indicsOfParentheses.push(i - reduce);
            }
            else if(chars[i] == ')'){
                if(indicsOfParentheses.size() > 0 && indicsOfParentheses.peek() >= 
                    0){
                    indicsOfParentheses.pop();
                }
                else{
                    reduce++;
                    add = false;
                }
            }
            
            if(add) sb.append(chars[i]);
        }
        
        while(indicsOfParentheses.size() != 0){
            int index = indicsOfParentheses.pop();
            sb.delete(index, index + 1);
        }
        
        return sb.toString();
    }
}