class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList();
        
        solve(res, n, n, new StringBuilder());
        
        return res;
    }
    
    void solve(List<String> res, int open, int close, StringBuilder sb){
        
        if(open == 0 && close == 0){
            res.add(sb.toString());
            return;
        }
        
        if(open > 0){
            sb.append("(");
            solve(res, open - 1, close, sb);
            sb.deleteCharAt(sb.length() - 1); 
        }
        
        if(open < close && close > 0){

            sb.append(")");

            solve(res, open, close - 1, sb);

            sb.deleteCharAt(sb.length() - 1); 

        }
    }
}