class Solution {
    public List<Integer> getRow(int rowIndex) {
        int row = 0;
        List<Integer> rowList = new ArrayList<>();
        rowList.add(1);
        
        while(row < rowIndex){
            List<Integer> nextRow = new ArrayList<>();
            
            nextRow.add(1);
            
            for(int i = 0; i < rowList.size(); i++){
                int value = rowList.get(i);
                if(i + 1 < rowList.size()){
                    value += rowList.get(i + 1);
                }
                
                nextRow.add(value);
            }
            
            rowList = new ArrayList<>(nextRow);
            row++;
            
        }
        
        return rowList;
    }
}