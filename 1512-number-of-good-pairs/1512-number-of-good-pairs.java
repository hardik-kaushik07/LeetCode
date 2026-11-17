class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int goodPairs = 0;
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        for(int i = 0; i < nums.length; i++){
            if(map.get(nums[i])>1){
                goodPairs += map.get(nums[i])-1;
            }
        }
        return goodPairs/2;
    }
}