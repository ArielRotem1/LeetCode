class Solution {
    public boolean stoneGameIX(int[] stones) {
        int[] count = new int[3];
        
        boolean every3 = true;
        
        for(int stone : stones){
            count[stone % 3]++; 
        }
        
        return get(Arrays.copyOf(count, count.length), 1, 2) || get(Arrays.copyOf(count, count.length), 2, 1);
    }
    
    private boolean get(int[] count, int start, int end){
        
        if(count[start] < 1) return false;
        
        count[start]--;
        
        while(true){
            if(count[start] == 0 && count[end] == 0) return false;
            else if(count[start] == 0){
                if(count[0] % 2 == 1) return false;
                else return true;
            }
            
            count[start]--;
            
            if(count[start] == 0 && count[end] == 0) return false;
            else if(count[end] == 0){
                if(count[0] % 2 == 1) return true;
                else return false;
            }
            
            count[end]--;
        }
    }
}
