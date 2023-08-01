//Time: O()
//Space: O(n!)
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new LinkedList<>();
        createCombinations(result, n, k, new LinkedList<Integer>(), 1);
        return result;
    }

    void createCombinations(List<List<Integer>> result, int n, int k, List<Integer> curr, int startNum){

        if(k == curr.size()){
            result.add(new LinkedList<>(curr));
            return;
        }

        //number of numbers left to add: (n - i + 1)
        //it has started from this condition: (n - i + 1) + combinationSize >= k
        int theLimitNumberFromWhichCantReachFullList = n + 1 + curr.size() - k;

        for(int i = startNum; i <= Math.min(n, theLimitNumberFromWhichCantReachFullList); i++){
            curr.add(i);
            createCombinations(result, n, k, curr, i + 1);
            curr.remove(curr.size() - 1);
        }
    }
}
