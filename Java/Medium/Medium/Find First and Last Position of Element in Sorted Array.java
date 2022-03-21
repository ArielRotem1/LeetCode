class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        
        while(left <= right){
            int middle = (int) ((right - left) / 2) + left;
            
            if(target > nums[middle]){
                left = middle + 1;
            }
            else{
                right = middle - 1;
            }
        }
        
        int start = right + 1 < nums.length && nums[right + 1] == target ? right + 1 : -1;
        
        left = 0;
        right = nums.length - 1;
        
        while(left <= right){
            int middle = (int) ((right - left) / 2) + left;
            
            if(target >= nums[middle]){
                left = middle + 1;
            }
            else{
                right = middle - 1;
            }
        }
        
        int end = left - 1 >= 0 && nums[left - 1] == target ? left - 1 : -1;
        return new int[]{start, end};
    }
}
