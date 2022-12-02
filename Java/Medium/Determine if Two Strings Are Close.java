class Solution {
    //Time: O(n) - n: word1.length()
    //Space: O(n)
    public boolean closeStrings(String word1, String word2) {
        
        //if the strings are not in the same size then they can never be close
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        if(chars1.length != chars2.length) return false;
        
        //check that word1 has all kinds of chars of word2 and vice versa
        //and also get the number of appearances of each char in word1
        int[] numberOfChar = new int[26];
        
        int charsInWord1 = 0, charsInWord2 = 0;
        for(char c : chars1){
            int ascii = c - 'a';
            numberOfChar[ascii]++;
            charsInWord1 |= 1 << ascii;
        }
        
        int[] numberOfCharArray = new int[chars1.length + 1];
        
        int numberOfInsertion = 0;
        
        //create a counter array of the number of appearances
        for(int numberOfCharAppearances : numberOfChar){
            if(numberOfCharAppearances == 0) continue;
            
            numberOfCharArray[numberOfCharAppearances]++;
            numberOfInsertion++;
        }
        
        //clear numberOfChar
        Arrays.fill(numberOfChar, 0);
        
        //get the number of appearances of each char in word2
        for(char c : chars2){
            int ascii = c - 'a';
            numberOfChar[ascii]++;
            charsInWord2 |= 1 << ascii;
        }
        
        //if xor on the bit representation of the chars is zero it means they have the same chars
        if((charsInWord1 ^ charsInWord2) > 0) return false;
        
        //remove form the counter array the number of appearances
        for(int numberOfCharAppearances : numberOfChar){
            if(numberOfCharAppearances == 0) continue;

            if(--numberOfCharArray[numberOfCharAppearances] < 0) return false;
            
            numberOfInsertion--;
        }
        
        return numberOfInsertion == 0;
    }
}
