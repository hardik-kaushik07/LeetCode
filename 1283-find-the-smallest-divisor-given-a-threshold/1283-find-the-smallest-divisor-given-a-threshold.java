class Solution {
    public int smallestDivisor(int[] nums, int limit) {
        return binarySearch(nums, limit);
    }
    public int findMax(int[] nums){
        int maxi = Integer.MIN_VALUE;
        for(int ele: nums){
            maxi = Math.max(maxi, ele); 
        }
        return maxi;
    } 
    public int binarySearch(int[] nums, int limit){
        int low = 1, high = findMax(nums);
        while(low<high){
            int mid = low + (high-low)/2;
            if(smallerDivisor(nums, mid)<=limit){
                high = mid;
            }
            else{
                low = mid+1;
            }
        }
        return low;
    }
    public long smallerDivisor(int[] nums, int mid){
        long sum = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i]%mid!=0){
                sum += nums[i]/mid + 1;
            }
            else{
                sum += nums[i]/mid;
            }
        }
        return sum;
    }
}