class Solution {
    public String getSmallestString(int n, int k) {
        StringBuilder sb = new StringBuilder();
        
        while(k - n >= 26){
            sb.insert(0, 'z');
            k -= 26;
            n--;
        }
      
        if(k - n > 0){
            sb.insert(0, (char) (k - n + 'a'));
            n--;
        }
        
        while(n > 0){
            sb.insert(0, 'a');
            n--;
        }
        
        return sb.toString();
    }
}
