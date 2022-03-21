class Solution {
    public int maxArea(int[] height) {
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
    }
}
