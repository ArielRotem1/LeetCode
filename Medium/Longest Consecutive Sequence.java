import java.util.*;
class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return 1;
        PriorityQueue<Integer> pq = new PriorityQueue();
        
        for(int num : nums){
            pq.add(num);
        }
        
        
        int number = pq.poll();
        int counter = 1;
        int best = 1;
        
        while(pq.isEmpty() == false){
            int temp = pq.poll();
            if(number + 1 == temp){
                counter++;
            }
            else if(number != temp){
                best = Math.max(best, counter);
                counter = 1;
            }
            
            number = temp;
        }
        
        best = Math.max(best, counter);
        
        return best;
    }
}