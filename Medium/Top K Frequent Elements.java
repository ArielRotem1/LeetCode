import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Hashtable<Integer, Integer> ht = new Hashtable();
        for(int num : nums){
            if(ht.containsKey(num))
                ht.put(num, ht.get(num) + 1);
            else
                ht.put(num, 1);
        }
        
        
        PriorityQueue<Integer> pq = new PriorityQueue((n1, n2) -> ht.get(n1) - ht
            .get(n2));
            
        for(int key : ht.keySet()){
            pq.offer(key);
            if(pq.size() > k) pq.poll();
        }
        
        int[] result = new int[k];
        
        for(int i = 0; i < k; i++){
            result[i] = pq.poll();
        }
        
        return result;
        
    }
}