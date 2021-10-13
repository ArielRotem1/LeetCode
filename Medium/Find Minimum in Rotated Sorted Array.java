class Solution {
    public int findMin(int[] nums) {
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
                    return nums[right];
                }
            }
        }
        
        return nums[left];
    }
}
