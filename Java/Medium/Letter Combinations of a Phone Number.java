class Solution {
    HashMap<Integer, Character[]> charsForNumber;
    
    public List<String> letterCombinations(String digits) {
        //I have chose to use LinkedList instead of ArrayList because in this problem
        //you only need to add the elements and not searched through them
        LinkedList<String> letterCombinations = new LinkedList<String>();
        
        if(digits.length() == 0) return letterCombinations;
        
        charsForNumber = new HashMap<>();

        charsForNumber.put(2, new Character[]{'a', 'b', 'c'});
        charsForNumber.put(3, new Character[]{'d', 'e', 'f'});
        charsForNumber.put(4, new Character[]{'g', 'h', 'i'});
        charsForNumber.put(5, new Character[]{'j', 'k', 'l'});
        charsForNumber.put(6, new Character[]{'m', 'n', 'o'});
        charsForNumber.put(7, new Character[]{'p', 'q', 'r', 's'});
        charsForNumber.put(8, new Character[]{'t', 'u', 'v'});
        charsForNumber.put(9, new Character[]{'w', 'x', 'y', 'z'});
        
        getLetterCombinations(digits, 0, "", letterCombinations);
        
        return letterCombinations;
    }
    
    private void getLetterCombinations(String digits, int index, String currComb, List<String> letterCombinations){
        
        if(index == digits.length()){
            letterCombinations.add(currComb);
            return;
        }
        
        for(Character chrInDigit : charsForNumber.get(Character.getNumericValue(digits.charAt(index)))){
            getLetterCombinations(digits, index + 1, currComb + chrInDigit, letterCombinations);
        }
    }
}
