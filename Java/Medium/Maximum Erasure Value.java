class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        
        //This is the better approach, because it is using hashset and not hashmap which make it more space efficient
        //and the run time is still the same
        //Time: O(n)
        //Space: O(n)
        int max = 0;
        HashSet<Integer> hs = new HashSet<Integer>();
        
        int start = 0, end = 0, windowSum = 0;
        while(end < nums.length){
            int currNum = nums[end];
            
            windowSum += currNum;
            
            if(!hs.contains(currNum)){
                max = Math.max(max, windowSum);
            }
            else{
                while(currNum != nums[start]){
                    windowSum -= nums[start];
                    hs.remove(nums[start]);
                    start++;
                }
                windowSum -= nums[start];
                start++;
            }
            
            hs.add(currNum);
            
            end++;
        }
        
        return max;
    }
    
    /*
    class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int max = 0;
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        
        int start = 0, end = 0, windowSum = 0;
        while(end < nums.length){
            int currNum = nums[end];
            
            windowSum += currNum;
            
            if(!hm.containsKey(currNum)){
                max = Math.max(max, windowSum);
            }
            else{
                int prevNumIndex = hm.get(currNum);
                while(prevNumIndex >= start){
                    windowSum -= nums[start];
                    start++;
                }
                max = Math.max(max, windowSum);
            }
            
            hm.put(currNum, end);
            
            end++;
        }
        
        return max;
    }
    */
}
