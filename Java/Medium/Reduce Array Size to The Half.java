class Solution {
    public int minSetSize(int[] arr) {
        //Time: O(nlog(n))
        //Space: O(3n) => O(n)
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int num : arr){
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }
        
        List<Integer> result = new ArrayList<>(hm.values());
        Collections.sort(result);
        
        int minSize = 0;
        int size = arr.length;
        int idx = result.size() - 1;
        while(size > arr.length / 2){
            size -= result.get(idx);
            idx--;
            minSize++;
        }
        
        return minSize;
    }
}
