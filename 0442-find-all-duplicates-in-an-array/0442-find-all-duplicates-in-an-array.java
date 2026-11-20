class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        // Set<Integer> set = new HashSet<>();
        List<Integer> ans = new ArrayList<>();

        // for(int i = 0; i < nums.length; i++){
        //     if(set.contains(nums[i])){
        //         ans.add(nums[i]);
        //     }
        //     set.add(nums[i]);
        // }
        // return ans;


        for(int i = 0; i < nums.length; i++){
            int idx = Math.abs(nums[i])-1;
            if(nums[idx]<0){
                ans.add(idx+1);
            }
            nums[idx] *= -1;
        }
        return ans;
    }
}