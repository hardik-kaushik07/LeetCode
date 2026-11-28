class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        if(sum%2 != 0){
            return false;
        }

        int target = sum/2;

        int[][] dp = new int[nums.length][target+1];
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                dp[i][j] = -1;
            }
        }

        return solve(nums, target, 0, dp);
    }

    public boolean solve(int[] nums, int target, int idx, int[][] dp){

        if(target==0){
            return true;
        }

        if(idx == nums.length || target < 0){
            return false;
        }
        if(dp[idx][target] != -1){
            if(dp[idx][target]==1) return true;
            else return false;
        }
        boolean ans2 = solve(nums, target, idx+1, dp);
        if(target-nums[idx] < 0){
            if(ans2 == false) dp[idx][target] = 0;
            else dp[idx][target] = 1;
        }
        boolean ans1 = solve(nums, target-nums[idx], idx+1, dp);
        

        if(ans1==true || ans2 == true){
            dp[idx][target] = 1;
        }
        else dp[idx][target] = 0;
        
        if(dp[idx][target]==1) return true;
        return false;
    }
}