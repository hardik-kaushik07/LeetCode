// class Solution {
//     public int removeDuplicates(int[] nums) {
//         int n = nums.length;
//         if (nums.length == 0) {
//             return 0;
//         }
//         Stack<Integer> st = new Stack<>();
//         st.push(nums[0]);
//         for(int i = 1 ;  i< n ; i ++){
//             while(st.size()!=0 && st.peek()==nums[i]){
//                 st.pop();
//             }
//             st.push(nums[i]);
//         }
//         int k = st.size();
//          for (int i = k - 1; i >= 0; i--) {
//             nums[i] = st.pop();
//         }
//         return k;
//     }
// }

class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (nums.length == 0) {
            return 0;
        }
        int i = 0, j = i+1;

        while(j<=nums.length-1 && i<j){
            if(nums[j]!=nums[i]){
                i++;
                nums[i] = nums[j];
            }
            j++;
        }
        return i+1;
    }
}