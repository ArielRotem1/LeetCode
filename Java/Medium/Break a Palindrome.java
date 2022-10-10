//Time: O(pal.length())
//Space: O(1)
class Solution {
    public String breakPalindrome(String pal) {
        
        if(pal.length() == 1) return "";
        
        StringBuilder res = new StringBuilder(pal);
        
        if(pal.length() % 2 == 1){
            boolean followAAABAAA = true;
            for(int i = 0; i < pal.length() / 2; i++){
                if(pal.charAt(i) != 'a' || pal.charAt(pal.length() - i - 1) != 'a'){
                    followAAABAAA = false;
                    break;
                }
            }
            
            if(followAAABAAA && pal.charAt(pal.length() / 2) != 'a'){
                res.setCharAt(res.length() - 1, 'b');
                return res.toString();
            }
        }


        for(int i = 0; i < pal.length(); i++){
            if(pal.charAt(i) != 'a'){
                res.setCharAt(i, 'a');
                return res.toString();
            }
        }


        res.setCharAt(res.length() - 1, 'b');
        return res.toString();
    }
}
