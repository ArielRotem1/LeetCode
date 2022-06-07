class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //Time: O(m + n)
        //Space: O(1)
        
        int nums1Index = m - 1, nums2Index = n - 1, indexToPut = m + n - 1;
        while(nums1Index > -1 && nums2Index > -1){
            int currNum1 = nums1[nums1Index];
            int currNum2 = nums2[nums2Index];
            
            if(currNum2 >= currNum1){
                nums1[indexToPut--] = currNum2;
                nums2Index--;
            }
            else{
                nums1[indexToPut--] = currNum1;
                nums1Index--;
            }
        }

        while(nums2Index > -1){
            nums1[indexToPut--] = nums2[nums2Index];
            nums2Index--;
        }
    }
}
