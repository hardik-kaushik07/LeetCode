class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            int digCount=0;
            while(nums[i]>0){
                int digit = nums[i]%10;
                digCount += 1;
                nums[i] = nums[i]/10;
            }
            if(digCount%2==0){
                count++;
            }
        }
        return count;
    }
}