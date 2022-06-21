class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        if(heights.length == 1) return 0;
        
        //Time: O(nlogn)
        //Space: O(n)
        
        PriorityQueue<Integer> maxDiffsHeight = new PriorityQueue<>((x, y) -> Integer.compare(y, x));
        
        int lastHeight = heights[0];
        for(int i = 1; i < heights.length; i++){
            if(lastHeight < heights[i]){
                if(bricks < heights[i] - lastHeight){
                    if(ladders > 0){
                        if(maxDiffsHeight.size() != 0 && maxDiffsHeight.peek() >= heights[i] - lastHeight){
                            bricks += maxDiffsHeight.poll();
                            maxDiffsHeight.add(heights[i] - lastHeight);
                            bricks -= heights[i] - lastHeight;
                        }
                        
                        ladders--;
                    }
                    else return i - 1;
                }
                else{
                    maxDiffsHeight.add(heights[i] - lastHeight);
                    bricks -= heights[i] - lastHeight;
                }
            }
            
            lastHeight = heights[i];
        }
        
        return heights.length - 1;
    }
}

