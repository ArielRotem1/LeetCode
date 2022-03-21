class Solution {
    public int scoreOfParentheses(String s) {
        return scoreOfParentheses(s, 0, 0);
    }
    
    private int scoreOfParentheses(String s, int index, int depth){
        int res = 0;
        
        while(index < s.length()){

            if(s.charAt(index) == '(' && s.charAt(index + 1) == ')'){
                res++;
                index += 2;
            }
            else if(s.charAt(index) == '(' && s.charAt(index + 1) == '('){
                res += 2 * scoreOfParentheses(s, index + 1, depth + 1);
                
                int counter = 1;
                index++;
                
                while(index < s.length() && counter > 0){
                    if(s.charAt(index) == ')') counter--;
                    else counter++;
                    
                    index++;
                }
            }
            else if(s.charAt(index) == ')'){
                if(depth != 0) return res;
                index++;
            }
        }

        return res;
    }
}
