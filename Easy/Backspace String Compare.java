class Solution {
    public boolean backspaceCompare(String s, String t) {
        int counterBackspace1 = 0, counterBackspace2 = 0;
        int index1 = s.length() - 1, index2 = t.length() - 1;
        
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        while(true){
            while(index1 > -1 && (sChars[index1] == '#' || (sChars[index1] != '#' && counterBackspace1 > 0))){
                if(sChars[index1] == '#')
                    counterBackspace1++;
                else
                    counterBackspace1--;
                index1--;
            }
            
            while(index2 > -1 && (tChars[index2] == '#' || (tChars[index2] != '#' && counterBackspace2 > 0))){
                if(tChars[index2] == '#')
                    counterBackspace2++;
                else
                    counterBackspace2--;
                index2--;
            }
            
            if(index1 == -1 && index2 == -1) return true;
            else if(index1 == -1 && index2 != -1) return false;
            else if(index1 != -1 && index2 == -1) return false;

            if(sChars[index1] != tChars[index2]) return false;
                  
            index1--;
            index2--;
        }
    }
}
