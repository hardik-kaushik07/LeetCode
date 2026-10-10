class Solution {
    public int numSquarefulPerms(int[] nums) {
        Arrays.sort(nums);
        boolean[] vis = new boolean[nums.length];
        return solve(nums, 0, vis, -1);
    }
    public int solve(int[] nums, int idx, boolean[] vis, int prev){
        if(idx >= nums.length){
            return 1;
        }
        int count = 0;
        
         for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i-1] && !vis[i-1] || !squareful(prev, nums[i]) && prev!= -1 || vis[i]){
            continue;
            }
            vis[i] = true;
            count += solve(nums, idx+1, vis, nums[i]);

            vis[i] = false;
        }

        return count;
    }

    public boolean squareful(int prev, int curr){
            int sum = prev + curr;
            if(Math.sqrt(sum) % 1 == 0){
                return true;
            }
            return false;
        }
}