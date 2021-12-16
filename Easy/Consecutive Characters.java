class Solution {
    public int maxPower(String s) {
        int max = 0, curr = 0;
        char[] cs = s.toCharArray();
        char c = s.charAt(0);
        
        for(char ch : cs){
            if(c == ch){
                curr++;
            }
            else{
                max = Math.max(max, curr);
                curr = 1;
                c = ch;
            }
        }
        
        max = Math.max(max, curr);
        
        return max;
    }
}