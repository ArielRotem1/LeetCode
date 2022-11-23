class Solution {
    //Time: O(n) - n: s.length()
    //Space: O(n)
    //In the worse case for space the String is "((((()))))" which means n/2 recursive calls 
    //which result in n call stack space taken
    
    //note: token: -1 = '-', -2 = '+', -3 = '(', -4 = ')'
    
    int index;
    
    public int calculate(String s) {
        char[] chars = s.toCharArray();
        int result = 0;
        index = 0;
        int token = getNextToken(chars);
        
        int addOp = 1;
        
        while(token >= -4){
            
            //token = '-'
            if(token == -1) addOp = -1;
            //token = '+'
            else if(token == -2) addOp = 1;
            //token = '('
            else if(token == -3){
                result += addOp * startNewClac(chars);
                addOp = 1;
            }
            //token = number
            else{
                result += addOp * token;
                addOp = 1;
            }
            
            token = getNextToken(chars);
        }
        
        return result;
    }
    
    private int startNewClac(char[] chars){
        int result = 0;
        int token = getNextToken(chars);
        
        int addOp = 1;
        
        while(token >= -4){
            
            //token = '-'
            if(token == -1) addOp = -1;
            //token = '+'
            else if(token == -2) addOp = 1;
            //token = '('
            else if(token == -3){
                result += addOp * startNewClac(chars);
                addOp = 1;
            }
            //token = ')'
            else if(token == -4){
                return result;
            }
            //token = number
            else{
                result += addOp * token;
                addOp = 1;
            }
            
            token = getNextToken(chars);
        }
        
        // the method does not supposed to reach here
        return -5;
    }
    
    private int getNextToken(char[] s){
        while(index < s.length && s[index] == ' ') index++;
        
        if(index >= s.length) return -5;
        
        if(!Character.isDigit(s[index])){
            int result = 0;
            if(s[index] == '-') result = -1;
            else if(s[index] == '+') result = -2;
            else if(s[index] == '(') result = -3;
            else if(s[index] == ')') result = -4;
            
            index++;
            return result;
        }
        
        
        int result = 0;
        
        while(index < s.length && Character.isDigit(s[index])){
            result *= 10;
            result += s[index] - '0';
            index++;
        }
        
        return result;
    }
}
