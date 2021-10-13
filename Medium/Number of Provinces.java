import java.util.*;
import java.lang.*;

class Solution {
    public static int[][] globalIsConnected;
    public int findCircleNum(int[][] isConnected) {
        globalIsConnected = isConnected;
        
        int counter = 0;
        
        for(int i = 0; i < globalIsConnected.length; i++){
            if(globalIsConnected[i] != null){
                counter++;
                RemoveNodesConnected(i);
            }
        }
        
        return counter;
    }
    
    private void RemoveNodesConnected(int i){
        int[] connectedList = globalIsConnected[i];
        globalIsConnected[i] = null;
        
        for(int j = 0; j < connectedList.length; j++){
            if(connectedList[j] == 1 && i != j && globalIsConnected[j] != null){
                RemoveNodesConnected(j);
            }
        }
    }
}
