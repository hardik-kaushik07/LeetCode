class Solution {
    private int binarySearch(int[] nums, int target , int low , int high) {
       
       if(low>high) return low;
       int mid = low + (high-low)/2;
       if(nums[mid]==target) return mid;
 if (nums[mid] < target)
            return binarySearch(nums, target, mid + 1, high);
     return binarySearch(nums , target , low , mid-1);
    }
    public int searchInsert(int[] nums, int target){
        return binarySearch( nums,  target ,  0 , nums.length-1);
    }

}