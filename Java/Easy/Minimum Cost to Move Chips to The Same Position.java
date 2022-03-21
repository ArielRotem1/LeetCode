class Solution {
    public int minCostToMoveChips(int[] position) {
        int evenCount = 0, oddCount = 0;
        for(int pos : position){
            if(pos % 2 == 0) evenCount++;
            else oddCount++;
        }
        
        if(evenCount > oddCount) return oddCount;
        else return evenCount;
    }
}