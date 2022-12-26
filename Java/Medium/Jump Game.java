class Solution {
    //Time: O(n) - n: nums.length
    //Space: O(1)
    public boolean canJump(int[] nums) {
        int maxIndexReached = 0;

        for(int i = 0; i < nums.length; i++){
            if(i > maxIndexReached) return false;

            maxIndexReached = Math.max(maxIndexReached, i + nums[i]);
        }

        return true;
    }
}
