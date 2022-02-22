class Solution {
    public int titleToNumber(String columnTitle) {
        int sum = 0;
        
        for(int i = 0; i < columnTitle.length(); i++){
            int num = (int) columnTitle.charAt(i);
            num -= 64;
            sum = num + sum * 26;
        }
        
        return sum;
    }
}
