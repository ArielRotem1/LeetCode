class Solution {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });
        
        List<int[]> list = new ArrayList<>();
        int i = 0;
        for( ;i < intervals.length - 1; i++){
            int start = intervals[i][0];
            int e = intervals[i][1];
            int s2 = intervals[i + 1][0];
            
            while(e >= s2){
                i++;
                e = Math.max(e, intervals[i][1]);
                if(i + 1 == intervals.length) break;
                s2 = intervals[i + 1][0];
            }
            
            list.add(new int[]{start,e});
        }
        
        if(i == intervals.length - 1){
            list.add(intervals[i]);
        }
        
            
        return list.toArray(new int[list.size()][]);
    }
}