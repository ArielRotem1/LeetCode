class Solution {
    public int coinChange(int[] coins, int amount) {
        
        //Tabulation
        int[] table = new int[amount + 1];
        for(int i = 0; i <= amount; i++) table[i] = -1;
        table[0] = 0;
        
        
        for(int i = 0; i < amount; i++){
            if(table[i] != -1){
                for(int coin : coins){
                    if(i + coin > 0 && i + coin <= amount){
                        if(table[i + coin] == -1) table[i + coin] = table[i] + 1;
                        else table[i + coin] = Math.min(table[i + coin], table[i] + 1);
                    }
                }
            }
        }
        
        return table[amount];
        
        
        //Memoization
        //return solve(coins, amount, new int[amount + 1]);
    }
    
    //Memoization
//     private int solve(int[] coins, int amount, int[] memo){
//         if(amount == 0) return 0;
        
//         if(memo[amount] != 0) return memo[amount];
        
//         int minNumberOfCoinsUsed = Integer.MAX_VALUE;
        
//         for(int coin : coins){
//             if(coin <= amount){
//                 int result = solve(coins, amount - coin, memo);
//                 if(result == -1) continue;
//                 minNumberOfCoinsUsed = Math.min(minNumberOfCoinsUsed, result + 1);
//             }
//         }
        
//         memo[amount] = minNumberOfCoinsUsed == Integer.MAX_VALUE ? -1 : minNumberOfCoinsUsed;
//         return memo[amount];
//     }
}
