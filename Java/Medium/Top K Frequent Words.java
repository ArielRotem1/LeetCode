class Solution {
    
    //Time: O(n log(k))
    //Space: O(n)
    public List<String> topKFrequent(String[] words, int k) {
        //Space: O(n)
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        //Time: O(n)
        for(String word : words){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        //Space: O(k)
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<Map.Entry<String, Integer>>((a, b) ->{
            if(a.getValue() == b.getValue()){
                return b.getKey().compareTo(a.getKey());
            }
            return a.getValue() - b.getValue();
        });
        
        //Time: O(n log(k))
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.add(entry);
            if(pq.size() == k + 1) pq.poll();
        }
        
        //Time: O(k)
        //Space: O(k)
        List<String> res = new ArrayList<>(k);
        while(!pq.isEmpty()){
            res.add(0, pq.poll().getKey());
        }
            
        return res;
    }
}
