class Solution {
    public int maxArea(int[] height) {
        // Time: O(n)
        // Space: O(1)
        int left = 0, right = height.length - 1, maxArea = 0;
        
        while(left < right){
            if(height[left] < height[right]){
                maxArea = Math.max(maxArea, height[left] * (right - left));
                left++;
            }
            else{
                maxArea = Math.max(maxArea, height[right] * (right - left));
                right--;
            }
        }
        
        return maxArea;
        
        
        
        /*
        Time: O(n^2)
        Space: O(1)
        int max = 0;
        for(int i = 0; i < height.length; i++){
            int width = 1;
            for(int j = i + 1; j < height.length; j++){
                int maxHeightAllowed = Math.min(height[i], height[j]);
                if(max < width * maxHeightAllowed){
                    max = width * maxHeightAllowed;
                }
                width++;
            }
        }
        return max;
        */
    }
}
