class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        //Time: O(nlogn)
        //Space: O(n)
        Arrays.sort(boxTypes, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(b[1], a[1]);
            }
        });
        
        int units = 0;
        for(int i = 0; i < boxTypes.length && truckSize > 0; i++){
            int numberOfBoxes = Math.min(truckSize, boxTypes[i][0]);
            units += numberOfBoxes * boxTypes[i][1];
            
            truckSize -= numberOfBoxes;
        }
        
        return units;
    }
}
