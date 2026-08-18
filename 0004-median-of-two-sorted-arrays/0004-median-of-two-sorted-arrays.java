class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length; 
        int m = nums2.length;
        int i = 0 , j = 0 , k = 0;
        int[] c = new int[n+m];
        while(i<n && j<m){
            if(nums1[i]<nums2[j]){
                c[k] = nums1[i];
                k++; i++;
            }
            else{
                c[k]=nums2[j];
                k++ ; j++;
            }
            
        }
        if(j==m){ while(i<n){
            c[k]=nums1[i];
            i++; k++;
        }}
       else{  while(j<m){
            c[k]=nums2[j];
            j++; k++;
        }}
        
        int v = c.length;
        double median;
        if(v%2==0){
            median = ((c[(v-1)/2]) + (c[(v)/2]))/2.0;
        }
        else{
            median = c[(v)/2];
        }
        return median;
    }
}