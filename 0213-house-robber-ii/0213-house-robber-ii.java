class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int[] dp1 = new int[nums.length];
        Arrays.fill(dp1, -1);
        int[] dp2 = new int[nums.length];
        Arrays.fill(dp2, -1);
        int a = help(nums, dp1, 0);
        int b = hel(nums, dp2, 1);
        return Math.max(a,b);
    }
    public int help(int[] nums, int[] dp, int idx){
        if(idx>=nums.length-1) return 0;
        if(dp[idx]!=-1) return dp[idx];
        return dp[idx] = Math.max(nums[idx]+help(nums, dp, idx+2), help(nums, dp, idx+1));
    }
    public int hel(int[] nums, int[] dp, int idx){
        if(idx>=nums.length) return 0;
        if(dp[idx]!=-1) return dp[idx];
        return dp[idx] = Math.max(nums[idx]+hel(nums, dp, idx+2), hel(nums, dp, idx+1));
    }
} 