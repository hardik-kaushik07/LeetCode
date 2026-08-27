class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        return binarySearch(piles, h);
    }

    public int maxFunc(int[] piles){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < piles.length; i++){
            max = Math.max(max, piles[i]);
        }
        return max;
    }
    public int binarySearch(int[] piles, int h){
        int i = 1, j = maxFunc(piles);
        int ans = Integer.MAX_VALUE;
        while(i<=j){
            int mid = i + (j-i)/2;
            if(cal(piles, mid)<=h){
                ans = mid;
                j = mid-1;
            }
            else{
                i = mid+1;
            }
        }
        return ans;
    }

    public long cal(int[] piles, int mid){
        long totalHours = 0;

        for(int  i = 0; i < piles.length; i++){
           if(piles[i]%mid==0){
            totalHours += piles[i]/mid;
           }
           else{
            totalHours+= piles[i]/mid +1;
           }
        }
        return totalHours;
    }
}