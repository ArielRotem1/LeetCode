class Solution {
    //Time: O(n) - n: nums.length
    //Space: O(1)
    public int removeDuplicates(int[] nums) {
        int k = 1;
        for(int i = 1; i < nums.length; i++){
            int num = nums[i];
            if(nums[i - 1] != num){
                nums[k] = num;
                k++;
            }
        }
        
        
        return k;
    }
}
