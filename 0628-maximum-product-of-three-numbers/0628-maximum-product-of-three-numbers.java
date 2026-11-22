class Solution {
    public int maximumProduct(int[] nums) {
        // int first = Integer.MIN_VALUE;
        // int second = Integer.MIN_VALUE;
        // int third = Integer.MIN_VALUE;

        // int small1 = Integer.MAX_VALUE;
        // int small2 = Integer.MAX_VALUE;
        // for(int i = 0; i < nums.length; i++){
        //     if(first< nums[i]){
        //         third = second;
        //         second = first;
        //         first = nums[i];
        //     }
        //     else if(second < nums[i]){
        //         third = second;
        //         second = nums[i];
        //     }
        //     else if(third < nums[i]){
        //         third  = nums[i];
        //     }

        //     if(nums[i] < small1) {
        //         small2 = small1;
        //         small1 = nums[i];
        //     }
        //     else if(nums[i] < small2) {
        //         small2 = nums[i];
        //     }
        // }
        // return Math.max(first*second*third, first*small1*small2);

        Arrays.sort(nums);
        return Math.max(nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3], nums[0]*nums[1]*nums[2]);
    }
}