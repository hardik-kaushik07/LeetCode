class Solution {
    int[] dp;
    public int minCostClimbingStairs(int[] cost) {
         dp = new int[cost.length];
         Arrays.fill(dp, -1);
        int a = helper(cost, 0);
        int b = helper(cost, 1);
        return Math.min(a, b);
    }
    public int helper(int[] cost, int idx){
        if(idx >= cost.length) return 0;
        if(dp[idx] != -1) return dp[idx];
        return dp[idx] = cost[idx] + Math.min(helper(cost, idx+1), helper(cost, idx+2));
    }
}