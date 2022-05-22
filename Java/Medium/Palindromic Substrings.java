class Solution {
    public int countSubstrings(String s) {
        char[] chars = s.toCharArray();
        int counter = 0;
        
        for(int i = 0; i < chars.length; i++){
            int start = i, end = i;
            while(start >= 0 && end < chars.length && chars[start] == chars[end]){
                counter++;
                start--;
                end++;
            }
        }
        
        for(int i = 0; i < chars.length - 1; i++){
            int start = i, end = i + 1;
            while(start >= 0 && end < chars.length && chars[start] == chars[end]){
                counter++;
                start--;
                end++;
            }
        }
        
        return counter;
    }
}
