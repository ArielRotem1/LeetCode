class Solution {
    public int arrayNesting(int[] nums) {
        int l = 0;
        for(int i = 0; i < nums.length; i++){
            boolean[] vis = new boolean[nums.length];
            int v = nums[i];
            vis[v] = true;
            int t = 1;
            while(!vis[nums[v]]){
                t++;
                v = nums[v];
            }
            
            if(t > l) l = t;
        }
        
        return l;
    }
}
