import java.util.Stack;

class Solution {
    public String simplifyPath(String path) {
        
        Stack<String> pathStack = new Stack<>();
        
        StringBuilder temp = new StringBuilder();
        
        for(int i = 0; i < path.length(); i++){
            char c = path.charAt(i);
            if(c == '/'){
                if(temp.length() > 0){
                    String tempStr = temp.toString();
                    if(tempStr.equals("..")){
                        if(!pathStack.isEmpty()) pathStack.pop();
                    }
                    else if(!tempStr.equals(".")) pathStack.push(tempStr);

                    temp = new StringBuilder();
                }
            }
            else{
                temp.append(c);
            }
        }
        
        if(temp.length() > 0){
            String tempStr = temp.toString();
            if(tempStr.equals("..")){
                if(!pathStack.isEmpty()) pathStack.pop();
            }
            else if(!tempStr.equals(".")) pathStack.push(tempStr);
            
            temp = new StringBuilder();
        }
        
        for(String s : pathStack){
            temp.append("/");
            temp.append(s);
        }
        
        if(temp.length() == 0) temp.append("/");
        
        
        return temp.toString();
    }
}
