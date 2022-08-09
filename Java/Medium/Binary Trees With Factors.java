class Solution {
    
    //Time: O(n^2)
    //Space: O(n)
    public int numFactoredBinaryTrees(int[] arr) {
        int MOD = 1_000_000_007;
        long result = arr.length;
        
        Arrays.sort(arr);
        
        HashMap<Integer, Integer> numbers = new HashMap<>();
        for(int i = 0; i < arr.length; i++) numbers.put(arr[i], i);
        
        long[] dp = new long[arr.length];
        
        for(int i = 0; i < arr.length; i++){
            int number = arr[i];

            long numberOfTrees = 0;
            
            for(int j = i - 1; j > -1; j--){
                if(number % arr[j] == 0 && numbers.containsKey(number / arr[j])){
                    int child1Index = j;
                    int child2Index = numbers.get(number / arr[j]);
                    
                    if(dp[child1Index] > 0 || dp[child2Index] > 0){
                        numberOfTrees += (dp[child1Index] == 0 ? 1 : dp[child1Index] + 1) * (dp[child2Index] == 0 ? 1 : dp[child2Index] + 1);
                    }
                    else numberOfTrees++;
                }
            }
            
            dp[i] = numberOfTrees % MOD;
            result += dp[i];
        }
        
        return (int) (result % MOD);
    }
}
