class Solution {
    public String addStrings(String num1, String num2) {
         char[] chs1 = num1.toCharArray();
         char[] chs2 = num2.toCharArray();
        
        List<Character> chars1 = new ArrayList<>();
        List<Character> chars2 = new ArrayList<>();
        
        if(num1.length() > num2.length()){
            for(Character c : chs1){
                chars1.add(c);
            }

            for(Character c : chs2){
                chars2.add(c);
            }
        }
        else{
            for(Character c : chs1){
                chars2.add(c);
            }

            for(Character c : chs2){
                chars1.add(c);
            }
        }

        
        return solve(0, "", chars1, chars2, 0);
    }
    
    public String solve(int index, String result, List<Character> chars1, List<Character> chars2, int carry){
        if(index >= chars1.size() && index >= chars2.size()){
            if(carry > 0){
                result = carry + result;
            }
            return result;
        }

        int sum = carry;
        if(index < chars1.size()){
            sum += Character.getNumericValue(chars1.get(chars1.size() - index - 1));
        }
        
        if(index < chars2.size()){
            sum += Character.getNumericValue(chars2.get(chars2.size() - index - 1));
        }
        
        return solve(index + 1, (sum % 10) + result, chars1, chars2, sum / 10);
    }
}