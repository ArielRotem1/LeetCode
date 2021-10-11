class Solution {
    public int search(int[] nums, int target) {
        int pivotIndex = 0;
        int len = nums.length;
        
        int left = 0;
        int right = len - 1;
        if(nums[left] > nums[right]){
            while(left < right){
                int middle = left + (int)Math.floor((right - left) / 2);

                if(nums[left] < nums[middle]){
                    left = middle;
                }
                else if(nums[right] > nums[middle]){
                    right = middle;
                }
                else{
                    pivotIndex = len - right;
                    break;
                }
            }
        }
        
        left = 0;
        right = len - 1;
        
        while(left <= right){
            int middle = left + (int)Math.floor((right - left) / 2);
            
            int indexMiddle = middle - pivotIndex;
            
            if(indexMiddle < 0){
                indexMiddle += len;
            }
            
            if(target > nums[indexMiddle]){
                left = middle + 1;
            }
            else if(target < nums[indexMiddle]){
                right = middle - 1;
            }
            else{
                return indexMiddle;
            }
        }
        
        return -1;
    }
}
