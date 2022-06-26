class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int minWindowSum = Integer.MAX_VALUE;
        int currWindowSum = 0;
        int windowSizeFixed = cardPoints.length - k - 1;
        int windowSize = windowSizeFixed;
        int totalSum = 0;
        
        for(int i = 0; i < cardPoints.length; i++){
            totalSum += cardPoints[i];
            
            currWindowSum += cardPoints[i];
            
            if(windowSize == 0){
                minWindowSum = Math.min(minWindowSum, currWindowSum);
                currWindowSum -= cardPoints[i - windowSizeFixed];
            }
            else windowSize--;
        }
        
        if(windowSizeFixed == -1) return totalSum;
        return totalSum - minWindowSum;
    }
}
