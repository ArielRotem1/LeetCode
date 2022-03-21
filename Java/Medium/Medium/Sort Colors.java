class Solution {
    public void sortColors(int[] nums) {
        int numberOfZeros = 0;
        int numberOfOnes = 0;
        
        for(int num : nums){
            if(num == 0) numberOfZeros++;
            if(num == 1) numberOfOnes++;
        }
        
        int indexZero = 0;
        int indexOne = numberOfZeros;
        int indexTwo = indexOne + numberOfOnes;
        
        int i = 0;
        
        while(i < nums.length){
            
            // System.out.println();
            // System.out.println("i: " + i);
            // System.out.println("indexZero: " + indexZero);
            // System.out.println("indexOne: " + indexOne);
            // System.out.println("indexTwo: " + indexTwo);
            // System.out.println("nums: " + Arrays.toString(nums));
            // System.out.println();
            
            if(i < numberOfZeros){
                while(nums[i] != 0){
                    if(nums[i] == 1){
                        swap(i, indexOne, nums);
                        indexOne++;
                    }
                    else{// 2
                        swap(i, indexTwo, nums);
                        indexTwo++;
                    }
                }
                
                indexZero++;
            }
            else if(i < numberOfZeros + numberOfOnes){
                while(nums[i] != 1){
                    swap(i, indexTwo, nums);
                    indexTwo++;
                }
                
                indexOne++;
            }
            else{
                break;
            }
            
            
            i++;
        }
        

    }
    
    void swap(int index, int index2, int[] nums){
        int temp = nums[index];
        nums[index] = nums[index2];
        nums[index2] = temp;
    }
}