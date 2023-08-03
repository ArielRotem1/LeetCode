//Time: O(n^2) - n: digits.length()
//Space: O(n^2)
class Solution {
    HashMap<Integer, Character[]> charsForNumber;
    
    public List<String> letterCombinations(String digits) {
        //I have chosen to use LinkedList instead of ArrayList because in this problem
        //you only need to add the elements and not searched them
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

        int[] digitsInt = new int[digits.length()];
        int i = 0;
        for(char dig : digits.toCharArray()){
            digitsInt[i++] = ((int)dig) - 48;
        }
        
        getLetterCombinations(digitsInt, 0, new StringBuilder(), letterCombinations);
        
        return letterCombinations;
    }
    
    private void getLetterCombinations(int[] digitsInt, int index, StringBuilder currComb, List<String> letterCombinations){
        
        if(index == digitsInt.length){
            letterCombinations.add(currComb.toString());
            return;
        }
        
        for(Character chrInDigit : charsForNumber.get(digitsInt[index])){
            currComb.append(chrInDigit);
            getLetterCombinations(digitsInt, index + 1, currComb, letterCombinations);
            currComb.deleteCharAt(currComb.length() - 1);
        }
    }
}
