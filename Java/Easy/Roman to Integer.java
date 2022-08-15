class Solution {
    //Time: O(n)
    //Space: O(1)
    public int romanToInt(String s) {
        int result = 0;
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            switch(c){
                    case 'I': 
                        result += 1;
                        if(i + 1 < s.length()){
                            char nextChar = s.charAt(i + 1);
                            if(nextChar == 'V' || nextChar == 'X'){
                                result -= 2;
                            }
                        }
                        break;
                    case 'V':result += 5; break;
                    case 'X':
                        result += 10;
                        if(i + 1 < s.length()){
                            char nextChar = s.charAt(i + 1);
                            if(nextChar == 'L' || nextChar == 'C'){
                                result -= 20;
                            }
                        }
                        break;
                    case 'L': result += 50; break;
                    case 'C':
                        result += 100;
                        if(i + 1 < s.length()){
                            char nextChar = s.charAt(i + 1);
                            if(nextChar == 'D' || nextChar == 'M'){
                                result -= 200;
                            }
                        }
                        break;
                    case 'D': result += 500; break;
                    case 'M': result += 1000; break;
            }
        }
        
        return result;
    }
}
