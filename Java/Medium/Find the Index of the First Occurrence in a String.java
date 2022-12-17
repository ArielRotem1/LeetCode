class Solution {
    //Time: O(n) - n: haystack.length()
    //Space: O(n) ** can be done in O(1) but converting the strings to arrays make the time faster even that the space complexity is bigger
    public int strStr(String haystack, String needle) {
        char[] hay = haystack.toCharArray();
        char[] piece = needle.toCharArray();

        int needleIndex = 0;

        for(int i = 0; i < hay.length; i++){
            while(i < hay.length && needleIndex < piece.length && 
            hay[i] == piece[needleIndex]){
                i++;
                needleIndex++;
            }

            if(needleIndex == piece.length) return i - piece.length;

            i -= needleIndex;

            needleIndex = 0;
        }

        return -1;
    }
}
