class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] - b[0]);
        
        int[][] queue = new int[people.length][];
        
        for(int[] p : people){
            
            int nPeopleSameOrEmpty = 0;
            int i = 0;
            
            for(; i < queue.length && nPeopleSameOrEmpty < p[1]; i++){
                if(queue[i] == null || queue[i][0] == p[0]) nPeopleSameOrEmpty++;
            }
            
            while(queue[i] != null) i++;

            queue[i] = p;
        }
        
        return queue;
    }
}
