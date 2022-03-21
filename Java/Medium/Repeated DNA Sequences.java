import java.util.Hashtable;

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if(s.length() < 11) return new ArrayList();
        Hashtable<String, Integer> ht = new Hashtable();
        
        List<String> result = new ArrayList();
        
        char[] chars = s.toCharArray();
        
        StringBuilder sb = new StringBuilder(s.substring(0,10));
        
        int i = 10;

        
        String temp = sb.toString();
        
        ht.put(temp, 1);
        
        while(i < chars.length){
            sb.delete(0,1);
            sb.append(chars[i]);
            
            temp = sb.toString();
            if(ht.containsKey(temp)){
                if(ht.get(temp) == 1){ 
                    result.add(temp);
                    ht.put(temp, 2);
                }
            }
            else ht.put(temp, 1);
                
            i++;
        }
        
        return result;
    }
}