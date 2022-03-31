class Solution {
    public int findDuplicate(int[] nums) {
        //Time: O(n)
        //Space: O(1)
        //All the integers in nums appear only once except for precisely one integer which appears two or more times.
        
        int firstIndex = 0;
        
        int num = nums[0];
        nums[0] = 0;
        
        while(true){
            
            int nextNum = nums[num - 1];
            
            if(nums[num - 1] > 0) nums[num - 1] = -1;
            else{
                nums[num - 1]--;
                if(nums[num - 1] == -2) return num;
            }

            num = nextNum;
            
            boolean used = false;
            
            while(num <= 0){
                firstIndex++;
                num = nums[firstIndex];
                used = true;
            }
            
            if(used) nums[firstIndex] = 0;
        }
    }
}


