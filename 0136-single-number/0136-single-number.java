class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int ele: nums){
            map.put(ele, map.getOrDefault(ele,0)+1);
        }

        for(int val: nums){
            if(map.get(val)==1){
                return val;
            }
        }
        return 0;
    }
}