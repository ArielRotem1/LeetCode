class Solution {
    public int minSwapsCouples(int[] row) {
        int minSwaps = 0;
        
        //Time: O(row.length)
        //Space: O(row.length)
        
        int[] numToIndex = new int[row.length];
        
        for(int i = 0; i < row.length; i++){
            numToIndex[row[i]] = i; 
        }
        
        for(int i = 0; i < row.length; i += 2){
            if(row[i] == -1) continue;
            
            int cycleLength = 0;
            int num = row[i];
            row[i] = -1;
            
            //start cycle
            do{
                int coupleNum = getShouldBeCouple(num);
                int indexOfCoupleNum = numToIndex[coupleNum];
                row[indexOfCoupleNum] = -1;
                int nearIndex = getNearIndex(indexOfCoupleNum);
                num = row[nearIndex];
                row[nearIndex] = -1;
                cycleLength++;
            }
            while(num != -1);

            minSwaps += cycleLength - 1;
        }
        
        return minSwaps;
    }
    
    private int getShouldBeCouple(int num){
        if(num % 2 == 0) return num + 1;
        return num - 1;
    }
    
    private int getNearIndex(int index){
        if(index % 2 == 0) return index + 1;
        return index - 1;
    }
}
