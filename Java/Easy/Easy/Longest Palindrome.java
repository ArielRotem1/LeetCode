class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> ht = new HashSet<>();
        
        char[] cs = s.toCharArray();
        
        int length = 0;
        
        for(Character c : cs){
            if(ht.contains(c)){
                length+=2;
                ht.remove(c);
            }
            else{
                ht.add(c);
            }
        }
        
        if(ht.size() > 0) length++;
        
        return length;
    }
}