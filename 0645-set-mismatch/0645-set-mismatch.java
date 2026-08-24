class Solution {
    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int dup = -1;
        int miss = -1;
        if(nums[0]!=1){
            miss = 1;
        }
        for(int i = 1; i < nums.length; i++){
            if(nums[i]!=nums[i-1] && nums[i]!=nums[i-1]+1){
                miss = nums[i-1]+1;
            }
        }
        for(int i = 1; i < nums.length; i++){
            if(nums[i]==nums[i-1]){
                dup = nums[i];
            }
        }
        if(nums[nums.length-1]!=nums.length){
            miss = nums.length;
        }
        int[] arr = new int[2];
        arr[0] = dup;
        arr[1] = miss;
        return arr;
    }
}