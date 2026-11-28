class Solution {
    // public int coinChange(int[] coins, int amount) {
    //     int[][] dp = new int[coins.length][amount+1];
    //     for(int i = 0; i < dp.length; i++){
    //         for(int j = 0; j < dp[0].length; j++){
    //             dp[i][j] = -1;
    //         }
    //     }
    //     int ans = solve(amount, coins, 0, dp);
    //     if(ans == Integer.MAX_VALUE) return -1;
    //     return ans;
    // }

    // public int solve(int amount, int[] coins, int idx, int[][] dp){

    //     if(idx == coins.length){
    //         if(amount == 0) return 0;
    //         else return Integer.MAX_VALUE;
    //     }
    //     if(dp[idx][amount] != -1) return dp[idx][amount];
    //     int skip = solve(amount, coins, idx+1, dp);
    //     if(amount-coins[idx] < 0) return dp[idx][amount] = skip;
    //     int take = solve(amount-coins[idx], coins, idx, dp);
    //     if(take != Integer.MAX_VALUE) take = take + 1;
    //     return dp[idx][amount] = Math.min(skip, take);
    // }


// Normal Recursion:
    // public int coinChange(int[] coins, int amount) {
    //     int ans = solve(amount, coins, 0);
    //     if(ans == Integer.MAX_VALUE) return -1;
    //     return ans;
    // }

    // public int solve(int amount, int[] coins, int idx){

    //     if(idx == coins.length){
    //         if(amount == 0) return 0;
    //         else return Integer.MAX_VALUE;
    //     }
    //     int skip = solve(amount, coins, idx+1);
    //     int take = Integer.MAX_VALUE;
    //     if(amount-coins[idx]>=0){
    //         int res = solve(amount-coins[idx], coins, idx);
    //         if(res != Integer.MAX_VALUE){
    //             take = res + 1;
    //         }
    //     } 
    //     return Math.min(skip, take);
    // }

    int min = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {

        int[][] dp = new int[coins.length][amount+1];

        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        List<Integer> list = new ArrayList<>();

        solve(amount, coins, 0, list, dp);

        if(min == Integer.MAX_VALUE) return -1;
        return min;
    }

    public void solve(int amount, int[] coins, int idx,
                      List<Integer> list, int[][] dp) {

        if(amount == 0) {
            min = Math.min(min, list.size());
            return;
        }

        if(idx == coins.length) {
            return;
        }

        if(dp[idx][amount] != -1 && dp[idx][amount] <= list.size()) {
            return;
        }

        dp[idx][amount] = list.size();

        // Skip
        solve(amount, coins, idx+1, list, dp);

        // Take
        if(amount - coins[idx] >= 0) {

            list.add(coins[idx]);

            solve(amount-coins[idx], coins, idx, list, dp);

            // Backtracking
            list.remove(list.size()-1);
        }
    }

}