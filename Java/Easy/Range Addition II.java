import java.util.*;

class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        if(ops.length == 0) return n * m;
        int minAi = Integer.MAX_VALUE;
        int minBi = Integer.MAX_VALUE;

        for(int[] arr : ops){
            minAi = Math.min(minAi, arr[0]);
            minBi = Math.min(minBi, arr[1]);
        }

        return minAi * minBi;
    }
}
