class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        
        //n - words.length, m - word[i].length
        //Time: O(n * m)
        //Space: O(n + 26*2) => O(n)
        
        List<String> result = new ArrayList<>();
        
        for(String word : words){
            int[] dict = new int[26];
            int[] revDict = new int[26];
            
            boolean shouldAddToResult = true;
            
            for(int i = 0; i < word.length(); i++){
                
                int chPattern = pattern.charAt(i) - 'a', chWord = word.charAt(i) - 'a';
                
                if(dict[chPattern] == 0){
                    dict[chPattern] = chWord + 1;
                }
                else if(dict[chPattern] != chWord + 1){
                    shouldAddToResult = false;
                    break;   
                }
                
                if(revDict[chWord] == 0){
                    revDict[chWord] = chPattern + 1;
                }
                else if(revDict[chWord] != chPattern + 1){
                    shouldAddToResult = false;
                    break;   
                }
            }
            
            if(shouldAddToResult) result.add(word);
        }
        
        return result;
    }
}
