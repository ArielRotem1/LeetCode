class Solution {
    public int maxProduct(String[] words) {
        
        //we can also use BitSet class to store true or false based on the characters in the word
        //instead of an Integer
        int[] charsInEachWord = new int[words.length];
        
        for(int i = 0; i < words.length; i++){
            String word = words[i];
            
            for(int j = 0; j < word.length(); j++){
                int chAscii = word.charAt(j) - 'a';
                charsInEachWord[i] = charsInEachWord[i] | (1 << chAscii);
            }
        }
        
        int max = 0;
        
        for(int i = 0; i < words.length; i++){
            for(int j = i + 1; j < words.length; j++){
                if((charsInEachWord[i] & charsInEachWord[j]) == 0){
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        
        
        return max;
    }
}
