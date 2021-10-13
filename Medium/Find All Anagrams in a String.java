import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        Hashtable<Character, Integer> hashTable = new Hashtable<>();
        
        char[] pchars = p.toCharArray();
        char[] sChars = s.toCharArray();
        for(char ch : pchars){
            if(hashTable.containsKey(ch))
                hashTable.put(ch, hashTable.get(ch) + 1);
            else
                hashTable.put(ch, 1);
        }
        
        int start = 0;
        int end = 0;
        
        int moneLen = 0;
        
        List<Integer> res = new ArrayList<>();
        
        int lenP = p.length();
        
        while(end < sChars.length){
            
            if(end - start < lenP){
                char charToAdd = sChars[end];
                if(hashTable.containsKey(charToAdd)){
                    if(hashTable.get(charToAdd) == 0){
                        hashTable.put(sChars[start], hashTable.get(sChars[start]) + 1);
                        start++;
                    }
                    else{
                        hashTable.put(charToAdd, hashTable.get(charToAdd) - 1);
                        end++;
                    }
                }
                else{
                    while(end < sChars.length && !hashTable.containsKey(sChars[end])){
                        end++;
                    }
                    
                    if(end == sChars.length){
                        end = 0;
                        break;
                    }
                    
                    while(start < end){
                        if(hashTable.containsKey(sChars[start]))
                            hashTable.put(sChars[start], hashTable.get(sChars[start]) + 1);
                        start++;
                    }
                }
            }
            else if(end - start == lenP){
                res.add(start);
                
                hashTable.put(sChars[start], hashTable.get(sChars[start]) + 1);
                start++;
            }
        }
        
        if(end - start == lenP){
            res.add(start);
        }
        
        return res;
    }
}
