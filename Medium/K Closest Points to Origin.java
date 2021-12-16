class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>(
            (a, b) -> { 
                double aDist = getEuclideanDist(a);
                double bDist = getEuclideanDist(b);
                if(aDist > bDist) return -1;
                else if(aDist < bDist) return 1;
                return 0;
            });
        
        for(int[] point : points){
            heap.add(point);
            if(heap.size() > k) heap.poll();
        }
        
        int[][] result = new int[k][2];
        
        for(int i = 0; i < k; i++){
            result[i] = heap.poll();
        }
        
        return result;
    }
    
    private double getEuclideanDist(int[] point){
        return Math.sqrt(point[0]*point[0] + point[1]*point[1]);
    } 
}