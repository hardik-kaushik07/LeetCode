class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        generate(ans, nums, 0, new ArrayList<>());
        return ans;
    }

    public void generate(List<List<Integer>> ans, int[] nums, int idx, List<Integer> list){

        if(idx >= nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[idx]);
        generate(ans, nums, idx+1, list);

        list.remove(list.size()-1);

        while(idx+1 < nums.length && nums[idx] == nums[idx+1]){
            idx++;
        }

        generate(ans, nums, idx+1, list);
    }
}