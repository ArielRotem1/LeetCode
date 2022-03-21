class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int counter = 0;
        
        for(List<String> item : items){
            if(isMatchGivenRule(item, ruleKey, ruleValue))
                counter++;
        }
        
        return counter;
    }
    
    private boolean isMatchGivenRule(List<String> item, String ruleKey, String ruleValue){
        
        if(ruleKey.equals("type")){
            return ruleValue.equals(item.get(0));
        }
        else if(ruleKey.equals("color")){
            return ruleValue.equals(item.get(1));
        }
        else{ // ruleKey == "name"
            return ruleValue.equals(item.get(2));
        }
    }
}
