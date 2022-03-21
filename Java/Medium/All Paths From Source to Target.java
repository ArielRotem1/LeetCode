import java.util.List;
import java.util.ArrayList;

class Solution {
    private int[][] graph;
    private List<List<Integer>> result;
    private List<Integer> currPath;
    private int goal;
    
    public List<List<Integer>> allPathsSourceTarget(int[][] g) {
        graph = g;
        result = new ArrayList<>();
        currPath = new ArrayList<>();
        goal = g.length - 1;
        
        currPath.add(0);
        
        DFS(0);
        
        return result;
    }
    
    private void DFS(int index){
        
        if(index == goal){
            result.add(new ArrayList<>(currPath));
            return;
        }
        
        for(int nextIndex : graph[index]){
            currPath.add(nextIndex);
            DFS(nextIndex);
            currPath.remove(currPath.size() - 1);
        }
    }
}
