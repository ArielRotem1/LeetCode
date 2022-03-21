import java.util.*;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        Hashtable<String, Integer> strings = new Hashtable<String, Integer>();
        
        String[] words = s.split(" ");
        char[] chars = pattern.toCharArray();
        
        if(words.length != chars.length) return false;
        
        for(int i = 0; i < chars.length; i++){
            int charValue = chars[i] - 'a';
            if(strings.containsKey(words[i]) == false){
                if(strings.contains(charValue)) return false;
                strings.put(words[i], charValue);
            }
            else if(strings.get(words[i]) != charValue){
                return false;
            }
        }
        
        
        return true;
    }
}