class Solution {
    public boolean judgeSquareSum(int c) {
        int a = 0;
        while(a * a <= c / 2){
            double result = Math.sqrt((a * a - c) * -1);
            if(result == (int)result){
                return true;
            }
            a++;
        }
        
        return false;
    }
}
