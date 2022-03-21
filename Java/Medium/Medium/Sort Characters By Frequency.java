import java.util.*;

class Solution {
    public String frequencySort(String s) {
        
        char[] chars = s.toCharArray();
        
        Hashtable<Character, Integer> ht = new Hashtable();
        for(Character c : chars){
            ht.put(c, ht.getOrDefault(c, 0) + 1);
        }
        
        PriorityQueue<String> pq = new PriorityQueue<>((n1, n2) -> n2.length() - n1
            .length());
            
        for(Character key : ht.keySet()){
            int val = ht.get(key);
            StringBuilder a = new StringBuilder();
            
            
            while(val > 0){
                a.append(key);
                val--;
            }
            
            pq.offer(a.toString());
        }
        
        StringBuilder result = new StringBuilder();
        
        String c = pq.poll();
        while(c != null){
            result.append(c);
            c = pq.poll();
        }
        
        return result.toString();
    }
}