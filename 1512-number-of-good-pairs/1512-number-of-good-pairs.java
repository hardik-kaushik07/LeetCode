class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int goodPairs = 0;
        for(int i = 0; i < nums.length; i++){
            int count = map.getOrDefault(nums[i],0);
            goodPairs += count;
            map.put(nums[i], count+1);
        }
        return goodPairs;
    }
}