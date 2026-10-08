class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(ans, candidates, target, new ArrayList<>(), 0);
        return ans;
    }

    public void backtracking(List<List<Integer>> ans, int[] nums, int target, List<Integer> list, int idx){

        if(target == 0){
                ans.add(new ArrayList<Integer>(list));
                return;
            }

        if (target < 0 || idx == nums.length) {
            return;
        }

        list.add(nums[idx]);
        backtracking(ans, nums, target-nums[idx], list, idx+1);

        list.remove(list.size()-1);

        while(idx+1 < nums.length && nums[idx] == nums[idx+1]){
            idx++;
        }

        backtracking(ans, nums, target, list, idx+1);

    }
}