class Solution {
    public static String[] numbers;
    public static int n;

    public String findDifferentBinaryString(String[] nums) {
        numbers = nums;
        n = numbers.length;
        
        return solve("");
    }
    
    public String solve(String result){
        if(result.length() == n){
            if(isResultInNumbers(result) == false){
                return result;
            }
            else{
                return "";
            }
        }
        
        //add "1"
        String res = solve(result + "1");
        if(res != "") return res;
        
        // add "0"
        res = solve(result + "0");
        if(res != "") return res;
        
        return "";
    }
    
    public boolean isResultInNumbers(String num){
        for(String s : numbers){
            if(s.equals(num)) return true;
        }
        return false;
    }
}
