class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount+1];
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                dp[i][j] = -1;
            }
        }
        int ans = solve(amount, coins, 0, dp);
        if(ans == Integer.MAX_VALUE) return -1;
        return ans;
    }

    public int solve(int amount, int[] coins, int idx, int[][] dp){

        if(idx == coins.length){
            if(amount == 0) return 0;
            else return Integer.MAX_VALUE;
        }
        if(dp[idx][amount] != -1) return dp[idx][amount];
        int skip = solve(amount, coins, idx+1, dp);
        if(amount-coins[idx] < 0) return dp[idx][amount] = skip;
        int take = solve(amount-coins[idx], coins, idx, dp);
        if(take != Integer.MAX_VALUE) take = take + 1;
        return dp[idx][amount] = Math.min(skip, take);
    }
}