class Solution {
    public int subarraySum(int[] nums, int k) {
        
        int mone = 0;
        int[] sumArray = new int[nums.length];
        
        int sum = nums[0];
        if(sum == k) mone++;
        for(int j = 1; j < nums.length; j++){
            sum += nums[j];
            sumArray[j] = sum;
            if(sum == k) mone++;
        }
        
        
        
        for(int i = 0; i < nums.length; i++){

            //System.out.println(Arrays.toString(sumArray));
            
            int temp = 0;
            
            for(int j = i + 1; j < sumArray.length; j++){
                temp = sumArray[j] - nums[i];
                if(temp == k)  mone++;
                sumArray[j] = temp;
            }
        }
        
        return mone;
    }
}