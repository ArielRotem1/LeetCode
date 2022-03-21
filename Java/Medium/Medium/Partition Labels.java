class Solution {
    public List<Integer> partitionLabels(String s) {
        char[] chars = s.toCharArray();
        
        List<Integer> result = new ArrayList<>();
        
        int currEnd = 0;
        int currIndex = 0;
        int startIndex = 0;
        
        while(currIndex < chars.length){
            
            for(int i = chars.length - 1; i > -1; i--){
                if(i == currEnd && currIndex == currEnd){
                    currEnd++;
                    result.add(currEnd - startIndex);
                    startIndex = currEnd;
                    currIndex = startIndex - 1;
                    break;
                }

                if(chars[currIndex] == chars[i]){
                    currEnd = Math.max(i, currEnd);
                    break;
                }
            }
            
            currIndex++;
        }
        
        return result;
    }
}