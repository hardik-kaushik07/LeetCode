class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int left = 1, right = 1, ans = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i]> nums[i-1]){
                left += 1;
            }
            else{
                left = 1;
            }
            if(nums[i]< nums[i-1]){
                right += 1;
            }
            else{
                right = 1;
            }
            ans = Math.max(ans, Math.max(left, right));
        }
        return ans;
    }
}