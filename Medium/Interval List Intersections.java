import java.util.*;

class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        
        List<int[]> intersections = new ArrayList<>();
        
        int index1 = 0;
        int index2 = 0;

        while(index1 < firstList.length && index2 < secondList.length){
            int[] p1 = firstList[index1];
            int[] p2 = secondList[index2];
            
            if((p1[0] <= p2[0] && p1[1] >= p2[0]) || (p2[0] <= p1[0] && p2[1] >= p1[0])){
                if(p1[1] > p2[1]){
                    if(p1[0] > p2[0])
                        intersections.add(new int[]{p1[0], p2[1]});
                    else
                        intersections.add(new int[]{p2[0], p2[1]});
                    index2++;
                }
                else{
                    if(p1[0] > p2[0])
                        intersections.add(new int[]{p1[0], p1[1]});
                    else
                        intersections.add(new int[]{p2[0], p1[1]});
                    index1++;
                }
            }
            else{
               if(p1[1] < p2[0]){
                    index1++;
                }
                else{
                    index2++;
                } 
            }
        }
        
        return intersections.toArray(new int[intersections.size()][2]);
    }
}
