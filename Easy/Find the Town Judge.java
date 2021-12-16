class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] haveTrustInHim = new int[n];
        
        for(int[] tr : trust){
            haveTrustInHim[tr[1] - 1]++;
            haveTrustInHim[tr[0] - 1] = -1;
        }
        
        for(int i = 0; i < n; i++){
            if(haveTrustInHim[i] == n - 1) return i + 1;
        }
        
        return -1;
    }
}