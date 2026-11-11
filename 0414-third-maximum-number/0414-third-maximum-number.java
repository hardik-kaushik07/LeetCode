class Solution {
    public int thirdMax(int[] nums) {
        int first = Integer.MIN_VALUE; 
        int second = Integer.MIN_VALUE;
        int thirdMax = Integer.MIN_VALUE;

        HashSet<Integer> dup = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
                if(dup.contains(nums[i])){
            continue;
            }
        dup.add(nums[i]);
        

        if(nums[i] >= first){
            thirdMax = second;
            second = first;
            first = nums[i];
            }
        else if(nums[i] >= second){
            thirdMax = second;
            second = nums[i];
            }
        else if (nums[i] >= thirdMax){
            thirdMax = nums[i];
            }
        }
        if(dup.size() < 3){
            return first;
        }
        return thirdMax;
    }
}