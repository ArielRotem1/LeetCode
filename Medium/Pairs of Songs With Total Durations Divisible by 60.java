import java.util.Hashtable;

class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        
        Hashtable<Integer, Integer> ht = new Hashtable();
        
        for(int i = 0; i < time.length; i++){
            int k = time[i] % 60;
            if(ht.containsKey(k)){
                ht.put(k, ht.get(k) + 1);
            }
            else ht.put(k, 1);
        }
               
        int m = 0;
        
        for(int i = 0; i < time.length; i++){
            int t = time[i] % 60;
            
            
            if(ht.containsKey(60 - t)){
                int val = ht.get(60 - t);
                m+=val;
                
                ht.put(t, ht.get(t) - 1);
                
                if(t == 30) m--;
            }
            else if(t == 0){
                if(ht.containsKey(t)){

                    int val = ht.get(t);
                    
             ht.put(t, ht.get(t) - 1);

                    m+=val;
                    
                    m--;

                }
            }
        }
               
        return m;
    }
}
