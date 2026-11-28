class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount+1];
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                dp[i][j] = -1;
            }
        }
        int ans = solve(amount, coins, 0, dp);
        return ans;
    }
    public int solve(int amount, int[] coins, int idx, int[][] dp){

        if(amount  == 0){
            return 1;
        }
        if(idx == coins.length || amount < 0 ){
            return 0;
        }
        if(dp[idx][amount] != -1) return dp[idx][amount];
        int skip = solve(amount, coins, idx+1, dp);
        if(amount-coins[idx] < 0) return dp[idx][amount] = skip;
        int take = solve(amount-coins[idx], coins, idx, dp);
        return dp[idx][amount] = take + skip;
    }
}