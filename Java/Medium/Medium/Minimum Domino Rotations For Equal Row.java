class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int[] dominosValuesCounter = new int[7];
        int[] countNumberInTops = new int[7];
        int[] countNumberInBottoms = new int[7];
        
        for(int i = 0; i < tops.length; i++){
            dominosValuesCounter[tops[i]]++;
            if(bottoms[i] != tops[i])
                dominosValuesCounter[bottoms[i]]++;
            
            countNumberInTops[tops[i]]++;
            countNumberInBottoms[bottoms[i]]++;
        }
        
        for(int i = 1; i < dominosValuesCounter.length; i++){
            if(dominosValuesCounter[i] == tops.length){ //can make a line of this number
                return tops.length - Math.max(countNumberInTops[i], countNumberInBottoms[i]);
            }
        }
        
        return -1;
    }
}
