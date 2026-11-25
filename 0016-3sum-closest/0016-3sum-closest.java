class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int i = 0, ans = nums[0] + nums[1] + nums[2];
        while(i < nums.length -2){
            int j = i + 1, k = nums.length -1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(Math.abs(target-sum) < Math.abs(target-ans)){
                    ans = sum;
                }
                else if(sum == target) return target;
                else if(sum < target) j ++;
                else k --;
            }
            i++;
        }
        return ans;
    }
}