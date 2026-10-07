class Solution {
    public int jump(int[] nums) {
        int max = 0, count = 0, end = 0;
        for(int  i = 0; i < nums.length-1; i++){

            max = Math.max(max, i+nums[i]);
            
            if(i==end){
                count++;
                end = max;
            }
            
        }
        return count;
    }
}