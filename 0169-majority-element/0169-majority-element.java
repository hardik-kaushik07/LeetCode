class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);

        int i = 0;
        int j = 0; 
        int count = 0;
        while(j<nums.length){
            if(nums[i]==nums[j]){
                count++;
                j++;
            }
            else if(count>(nums.length/2)){
                return nums[i];
            }
            else{
                i = j;
                count = 0;
            }
        }
        if(count>(nums.length/2)){
                return nums[i];
            }
        return 0;
    }
}