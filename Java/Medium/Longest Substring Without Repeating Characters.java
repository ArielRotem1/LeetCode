class Solution {
    public int lengthOfLongestSubstring(String s) {
        //Time: O(n)
        //Space: O(n)
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        
        int max = 0;
        int start = 0, end = 0;
        while(end < s.length()){
            
            char currChar = s.charAt(end);
            
            if(!hm.containsKey(currChar)){
                max = Math.max(max, end + 1 - start);
            }
            else{
                int prevCharIndex = hm.get(currChar);
                if(prevCharIndex < start){
                    max = Math.max(max, end + 1 - start);
                }
                else start = prevCharIndex + 1;
            }
            
            
            hm.put(currChar, end);
            end++;
        }
              
        return max;
    }
}
