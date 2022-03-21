class Solution {
    public int findGCD(int[] nums) {
        int minNumber = Integer.MAX_VALUE;
        int maxNumber = Integer.MIN_VALUE;

        for(Integer value : nums){
            minNumber = Math.min(minNumber, value);
            maxNumber = Math.max(maxNumber, value);
        }
        
        int gcd = minNumber;
        
        while(minNumber % gcd != 0 || maxNumber % gcd != 0){
            gcd--;
        }

        
        return gcd;
    }
}
