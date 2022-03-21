import java.util.*;

class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        Queue<double[]> que = new ArrayDeque<>();
        que.add(new double[]{query_glass, query_row, 0});
        
        Stack<double[]> path = new Stack<>();
        
        while(!que.isEmpty()){
            
            int queSize = que.size();
            
            Queue<double[]> nextQue = new ArrayDeque<>();
            
            if(!que.isEmpty()){
                double[] pos = que.poll();
                
                double col = pos[0];
                double row = pos[1];
            
                if(col == 0 && row == 0){
                    pos[2] = poured;
                    path.push(pos);
                    break;
                }
                
                path.push(pos);

                //up left
                if(col != 0) nextQue.add(new double[]{col - 1, row - 1, 0});
                //up right
                if(col != row) nextQue.add(new double[]{col, row - 1, 0});
            }
            
            while(!que.isEmpty()){
                
                double[] pos = que.poll();
            
                path.push(pos);
                
                double col = pos[0];
                double row = pos[1];
                
                //up right
                if(col != row) nextQue.add(new double[]{col, row - 1, 0});
            }
            
            que = nextQue;
        }
        
        List<double[]> a = new ArrayList<>();
        a.add(path.pop());
        double res = rec(a, path);
        if(res > 1) return 1;
        else return res;
    }
    
    private double rec(List<double[]> currentLayer, Stack<double[]> path){
        
        if(path.size() == 0) return currentLayer.get(0)[2];
        
        List<double[]> nextLayer = new ArrayList<>();
        
        double currentRow = currentLayer.get(0)[1];
        
        while(path.size() > 0 && path.peek()[1] - 1 == currentRow){
            nextLayer.add(path.pop());
        }
        
        if(currentLayer.size() > nextLayer.size()){
            for(int i = 0; i < nextLayer.size(); i++){
            
                double[] glass = currentLayer.get(i);
                glass[2] -= 1;

                if(glass[2] <= 0) continue;

                double[] nextGlass = nextLayer.get(i);
                nextGlass[2] += glass[2] / 2.0;

                if(i - 1 == -1) continue;
                double[] secondNextGlass = nextLayer.get(i - 1);
                secondNextGlass[2] += glass[2] / 2.0;
            }
            
            double[] glass = currentLayer.get(currentLayer.size() - 1);
            glass[2] -= 1;
            
            if(glass[2] > 0){
                double[] nextGlass = nextLayer.get(nextLayer.size() - 1);
                nextGlass[2] += glass[2] / 2.0;
            }
        }
        else{
            for(int i = 0; i < currentLayer.size(); i++){

                double[] glass = currentLayer.get(i);
                glass[2] -= 1;

                if(glass[2] <= 0) continue;

                double[] nextGlass = nextLayer.get(i);
                nextGlass[2] += glass[2] / 2.0;

                if(i + 1 == nextLayer.size()) break;
                double[] secondNextGlass = nextLayer.get(i + 1);
                secondNextGlass[2] += glass[2] / 2.0;
            }
        }
        
        return rec(nextLayer, path);
    } 
}
