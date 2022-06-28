class Solution {
    public int minDeletions(String s) {
        
        //Time: O(n)
        //Space: O(26) -> O(1)
        
        int[] charsFreq = new int[26];
        for(int i = 0; i < s.length(); i++){
            charsFreq[s.charAt(i) - 'a']++;           
        }
        
        //(O(26log26 -> O(1)))
        Arrays.sort(charsFreq);
        
        int currFreq = charsFreq[charsFreq.length - 1];
        int numberOfChars = 1;
        
        int numberOfDel = 0;
        
        for(int i = charsFreq.length - 2; i > -1 && charsFreq[i] > 0; i--){
            if(currFreq == charsFreq[i]) numberOfChars++;
            else{
                while(currFreq > charsFreq[i] && numberOfChars > 0){
                    numberOfChars--;
                    numberOfDel += numberOfChars;
                    currFreq--;
                }
                
                currFreq = charsFreq[i];
                numberOfChars++;
            }
        }
        
        while(currFreq > 0 && numberOfChars > 0){
            numberOfChars--;
            numberOfDel += numberOfChars;
            currFreq--;
        }
        
        return numberOfDel;
    }
}
