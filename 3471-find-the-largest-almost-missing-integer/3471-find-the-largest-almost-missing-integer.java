class Solution {
    public int largestInteger(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i <= nums.length - k; i++) {
            for (int j = i; j < i + k; j++) {
                map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            }
        }
        if (k == nums.length) {
            int max = nums[0];

            for (int i = 0; i < nums.length; i++) {
                max = Math.max(max, nums[i]);
            }

            return max;
        }
        if(k==1){
        int max = -1;

        for(int x = 0; x < nums.length; x++){
            if(map.get(nums[x])==1){
                max = Math.max(max,nums[x]);
            }
        }
        return max;
        }
        if(nums[0]==nums[nums.length-1]){
            return -1;
        }

        int max = -1;

        if(map.get(nums[0])==1){
            max = Math.max(max,nums[0]);
        }

        if(map.get(nums[nums.length-1])==1){
            max = Math.max(max,nums[nums.length-1]);
        }
        return max;
    }
}