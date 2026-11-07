class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;

        for(int ele : nums){
            if(ele != val){
                nums[k] = ele;
                k++;
            }
        }
        return k;
    }
}