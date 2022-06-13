class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {

        //Time: O(n^2)
        //Space: O(1)
        int row = triangle.size() - 1;
        while(row > 0){
            
            List<Integer> currRow = triangle.get(row);
            List<Integer> oneUpRow = triangle.get(row - 1);
            
            for(int i = 0; i < oneUpRow.size(); i++){
                int minSum = Math.min(currRow.get(i), currRow.get(i + 1));
                oneUpRow.set(i, minSum + oneUpRow.get(i));
            }
            
            row--;
        }
        
        return triangle.get(0).get(0);
    }
}
