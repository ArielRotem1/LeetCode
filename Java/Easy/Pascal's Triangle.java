class Solution {
    public List<List<Integer>> generate(int numRows) {
        //Time: 1 + 2 + 3 + 4 ... numRows -> n(n+1)/2 -> O(n^2)
        //Space: O(n^2)
        List<List<Integer>> ans = new ArrayList<>();
        
        List<Integer> currRow = new ArrayList<>();
        currRow.add(1);
        
        ans.add(currRow);
        
        while(numRows > 1){
            
            List<Integer> nextRow = new ArrayList<>();
            
            for(int i = 0; i < currRow.size() + 1; i++){
                if(i == 0 || i == currRow.size()){
                    nextRow.add(1);
                    continue;
                }
                
                nextRow.add(currRow.get(i - 1) + currRow.get(i));
            }
            
            ans.add(nextRow);
            currRow = nextRow;
            
            numRows--;
        }
        
        return ans;
    }
}
