class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int low = matrix[0][0];
        int high = matrix[matrix.length-1][matrix.length-1];

        while(low<high){
            int mid = low + (high-low)/2;

            int count = counting(matrix, mid);

            if(count<k){
                low = mid+1;
            }
            else{
                high = mid;
            }
        }
        return low;
    }

    public int counting(int[][] matrix, int target){

        int n = matrix.length;
        int count = 0;

        int left = 0, right = n-1;

        while(left<n && right>=0){
            if(matrix[left][right]<=target){
                count = count + right+1;
                left++;
            }
            else{
                right--;
            }
        }
        return count;
    }
}