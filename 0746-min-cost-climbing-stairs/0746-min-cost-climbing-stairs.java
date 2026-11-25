class Solution {
//  Using DP(Memoization):
    // int[] dp;
    // public int minCostClimbingStairs(int[] cost) {
    //      dp = new int[cost.length];
    //      Arrays.fill(dp, -1);
    //     int a = helper(cost, 0);
    //     int b = helper(cost, 1);
    //     return Math.min(a, b);
    // }
    // public int helper(int[] cost, int idx){
    //     if(idx >= cost.length) return 0;
    //     if(dp[idx] != -1) return dp[idx];
    //     return dp[idx] = cost[idx] + Math.min(helper(cost, idx+1), helper(cost, idx+2));
    // }

    // Using DP(Tabulation):
    public int minCostClimbingStairs(int[] cost) {
         int[] dp = new int[cost.length];
         dp[0] = cost[0]; dp[1] = cost[1];
         for(int i = 2; i < dp.length; i++){
            dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
         }
        return Math.min(dp[dp.length-1], dp[dp.length-2]);
    }

    // Using normal recursion:
    // public int minCostClimbingStairs(int[] cost) {
    //     int a = helper(cost, 0);
    //     int b = helper(cost, 1);
    //     return Math.min(a, b);
    // }
    // public int helper(int[] cost, int idx){
    //     if(idx >= cost.length) return 0;
    //     return cost[idx] + Math.min(helper(cost, idx+1), helper(cost, idx+2));
    // }
}