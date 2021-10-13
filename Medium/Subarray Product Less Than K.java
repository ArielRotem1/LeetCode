class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int mone = 0;
        
        int index = 0;
        
        int start = 0;
        int prod = 1;
        
        while(index < nums.length){
            prod *= nums[start];
            
            if(prod < k){
                // System.out.println();
                // System.out.println("start: " + start);
                // System.out.println("index: " + index);
                // System.out.println("prod: " + prod);
                // System.out.println();
                mone++;
            }
            else{
                index++;
                start = index - 1;
                prod = 1;
            }

            start++;
            
            if(start == nums.length){
                index++;
                start = index;
                prod = 1;
            }
        }
        
        return mone;
    }
}
