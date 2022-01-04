class Solution {
    public int findComplement(int num) {
        String binary = Integer.toBinaryString(num);
        int complement = 0;
        int mult = 1;
        
        for(int i = binary.length() - 1; i > -1; i--){
            if(binary.charAt(i) == '0'){
                complement += mult;
            }
            
            mult *= 2;
        }
        
        return complement;
    }
}
