import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList();
        
        Hashtable<String,Integer> ht = new Hashtable<>();
        
        for(String s : strs){
            char tempArray[] = s.toCharArray();
            Arrays.sort(tempArray);
            String sortedString = new String(tempArray);
            
            if(ht.containsKey(sortedString)){
                int index = ht.get(sortedString);
                result.get(index).add(s);
            }
            else{
                List<String> newList = new ArrayList();
                newList.add(s);
                result.add(newList);
                ht.put(sortedString, result.size() - 1);
            }
        }
        
        return result;
    }
}