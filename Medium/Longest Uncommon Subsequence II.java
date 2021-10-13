import java.util.*;

class Solution {
    private static List<String> subsequencesOfStr;
    private static int minDepth;
    
    public int findLUSlength(String[] strs) {
        List<String> strings = new ArrayList<String>(Arrays.asList(strs));
        List<String> sameStrings = new ArrayList<String>();
        
        while(true){
            Collections.sort(strings, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o2.length() - o1.length();
                }
            });
            
            String str = strings.get(0);
            boolean hasSameSequence = false;
            
            int maxLen = -1;

            for(int j = strings.size() - 1; j > 0; j--){
                if(str.equals(strings.get(j))){
                    hasSameSequence = true;
                    strings.remove(j);
                }
                else{
                    maxLen = Math.max(maxLen, strings.get(j).length());
                }
            }

            int len = str.length();

            if(!hasSameSequence){
                boolean returnLength = true;
                for(String s : sameStrings){
                    if(str.equals(s)){
                        if(strings.size() == 1) return -1;
                        else{
                            strings.remove(0);
                            subsequencesOfStr = new ArrayList<String>();
                            minDepth = maxLen;
                            findSubsequences(str);
                            for(String string : subsequencesOfStr){
                                sameStrings.add(string);
                            }
                            returnLength = false;
                            break;
                        }
                    }
                }
                
                if(returnLength)
                    return len;
            }
            else{
                if(maxLen != -1){
                    strings.remove(0);
                    subsequencesOfStr = new ArrayList<String>();
                    minDepth = maxLen;
                    findSubsequences(str);
                    for(String s : subsequencesOfStr){
                        sameStrings.add(s);
                    }
                }
                else return -1;
            }
        }
    }
    
    private void findSubsequences(String str){
        if(str.length() == minDepth){
            subsequencesOfStr.add(str);
            return;
        }
        
        for(int i = 0; i < str.length(); i++){
            StringBuilder tempStr = new StringBuilder(str);
            tempStr.deleteCharAt(i);
            findSubsequences(tempStr.toString());
        }
    }
}
