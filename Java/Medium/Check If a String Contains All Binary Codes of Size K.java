class Solution {
    public boolean hasAllCodes(String s, int k) {
        
        //Time: O(n)
        //Space: O(2^k)
        
        if(s.length() <= k) return false;
        
        int numberOfCombinations = 1 << k;//==(int) Math.pow(2, k);
        boolean[] combinationsFound = new boolean[numberOfCombinations];
        int currCount = 0;
        
        for(int i = 0; i < k - 1; i++){
            currCount |= ((s.charAt(i) - '0') << i);
        }
        
        
        for(int i = k - 1; i < s.length(); i++){
            currCount |= ((s.charAt(i) - '0') << (k - 1));
            
            if(!combinationsFound[currCount]){
                numberOfCombinations--;
                if(numberOfCombinations == 0) return true;

                combinationsFound[currCount] = true;
            }

            currCount = currCount >> 1; //==if(currCount % 2 == 1) currCount--; and currCount /= 2;
        }
        
        return false;
    }
}
