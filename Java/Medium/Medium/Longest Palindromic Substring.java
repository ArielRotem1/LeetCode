class Solution {
    public String longestPalindrome(String s) {
        
        //mine - start from largest possible palindrom 
        if(s.length() == 1) return s;
        
        char[] chars = s.toCharArray();
        
        int length = chars.length;
        
        while(length > 1){
            for(int i = 0; i + (length - 1) < chars.length; i++){
                if(isPal(chars, i, i + (length - 1))){
                    return s.substring(i, i + length);
                }
            }
            
            length--;
        }
        
        return "" + chars[0];
        
        //--------------------------
        //expand from center
        
        /*char[] chars = s.toCharArray();
        
        int start = 0, end = 0;
        
        for(int i = 0; i < chars.length - 1; i++){
            int len1 = expandAroundCenter(chars, i, i);
            int len2 = expandAroundCenter(chars, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        
        return s.substring(start, end + 1);*/
        
        //-------------------------------
        //DP
        
        /*char[] chars = s.toCharArray();
        
        boolean[][] dp = new boolean[chars.length][chars.length];
        
        int start = 0;
        int end = 0;
        
        for(int i = 0; i < chars.length; i++){
            dp[i][i] = true;
            if(i + 1 < chars.length && chars[i] == chars[i + 1]){
                dp[i][i + 1] = true;
                start = i;
                end = i + 1;
            }
        }
        
        for(int i = chars.length - 1; i > 0; i--){
            for(int j = 0; j + 1 < chars.length; j++){
                if(dp[i][j] && chars[i - 1] == chars[j + 1]){
                    dp[i - 1][j + 1] = true;
                    if((j + 1 + 1) - (i - 1) > end + 1 - start){
                        start = i - 1;
                        end = j + 1;
                    }
                }
            }
        }
        
        return s.substring(start, end + 1);*/
        
    }
    
    /*int expandAroundCenter(char[] chars, int left, int right){
         int L = left, R = right;
        while (L >= 0 && R < chars.length && chars[L] == chars[R]) {
            L--;
            R++;
        }
        return R - L - 1;
    }*/
    
    boolean isPal(char[] chars, int start, int end){
        for(;start < end && chars[start] == chars[end]; start++,end--);
        
        return start >= end;
    }
}