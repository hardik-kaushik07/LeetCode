class Solution {
    public int singleNonDuplicate(int[] arr) {
        int n = arr.length;

        int i = 0, j = n-1;
        while(i<j){
            int mid = i + (j-i)/2;

            if(mid%2==1){
                mid--;
            }

            if(arr[mid]==arr[mid+1]){
                i = mid+2;
            }
            else{
                j = mid;
            }
        }
        return arr[i];
    }
}