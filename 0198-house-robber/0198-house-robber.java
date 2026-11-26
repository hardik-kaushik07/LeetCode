class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp, -1);
        return helper(nums, dp, 0);
    }
    public int helper(int[] nums, int[] dp, int idx){
        if(idx>=nums.length){return 0;}
        if(dp[idx] != -1) return dp[idx];
        return dp[idx] = Math.max(nums[idx] + helper(nums, dp, idx+2), helper(nums, dp, idx+1));
    }
}