import java.util.*;

class Solution {
    public boolean isValidSerialization(String preorder) {
        int stackCount = 0;
        String[] preorderStringArray = preorder.split(",");
        
        for(int index = 0; index < preorderStringArray.length; index++){
            if(stackCount == 0 && index != 0) return false;
            else if(stackCount != 0) stackCount--;

            if(!preorderStringArray[index].equals("#")){
                stackCount += 2;
            }
        }
        
        return stackCount == 0;
    }
}