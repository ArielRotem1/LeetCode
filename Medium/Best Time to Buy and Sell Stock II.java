class Solution {
    public int maxProfit(int[] prices) {
        int prev = Integer.MAX_VALUE;
        int sum = 0;
        
        for(int price : prices){
            if(price > prev){
               sum += price - prev;
            }
            
            prev = price;
        }
        
        return sum;
    }
}