class Solution {
    public int findTheWinner(int n, int k) {
        if(n == 1 || k == 1) return n;
        
        int jump = k;
        
        if(k > n) jump %= n;
        
        Queue<Integer> queue = new ArrayDeque();
        
        for(int i = 1; i <= n; i++){
            queue.add(i);
        }
        
        int counter = 1;
        
        while(queue.size() > 1){

            while(counter < jump){
                queue.add(queue.poll());
                counter++;
            }
            
            queue.poll();
            
            counter = 1;
        }
        
        return queue.poll();
    }
}