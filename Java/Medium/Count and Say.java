class Solution {
    
    public String countAndSay(int n) {
        int counter = 1;
        String currentNum = "1";
        while(counter < n){
            currentNum = sayAndCount(currentNum);
            counter++;
        }
            
        return currentNum;
    }
    
    //Time: O(m) - m: num.length()
    //Space: O(m)
    private String sayAndCount(String num){
        char prev = num.charAt(0);
        int counter = 1;
        StringBuilder sb = new StringBuilder();
        
        for(int i = 1; i < num.length(); i++){
            while(i < num.length() && prev == num.charAt(i)){
                i++;
                counter++;
            }
            
            if(i < num.length()){
                sb.append(counter);
                sb.append(prev);
                counter = 1;
                prev = num.charAt(i);
            }
        }
        
        sb.append(counter);
        sb.append(prev);
        
        return sb.toString();
    }
}
