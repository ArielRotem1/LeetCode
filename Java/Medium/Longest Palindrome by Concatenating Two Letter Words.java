class Solution {
    public int longestPalindrome(String[] words) {
        int paliLen = 0;
        HashMap<String, Integer> hm = new HashMap<>();
        int stringsPal = 0;
        
        for(String word : words){
            
            if(word.charAt(0) == word.charAt(1)){
                stringsPal++;
            }
            
            if(hm.containsKey(word) && hm.get(word) > 0){
                if(word.charAt(0) == word.charAt(1)){
                    stringsPal -= 2;
                }

                paliLen += 4;

                hm.put(word, hm.get(word) - 1);
            }
            else{
                String pal = word.charAt(1) + "" + word.charAt(0);
                hm.put(pal, hm.getOrDefault(pal, 0) + 1);
            }
        }
        
        return paliLen + (stringsPal > 0 ? 2 : 0);
    }
}
