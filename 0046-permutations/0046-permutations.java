class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] freq = new boolean[nums.length];
        solve(nums, ans, freq, new ArrayList<>());
        return ans;
    }

    public void solve(int[] nums, List<List<Integer>> ans, boolean[] freq, List<Integer> list){

        if(list.size() >= nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }


        for(int i = 0; i < nums.length; i++){
            if(!freq[i]){
                list.add(nums[i]);
                freq[i] = true;

            solve(nums, ans, freq, list);
            list.remove(list.size()-1);

            freq[i] = false;
            }
            
        }
    }
}