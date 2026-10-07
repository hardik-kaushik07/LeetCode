class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        backtracking(ans, candidates, target, new ArrayList<>(), 0);
        return ans;
    }
    public void backtracking(List<List<Integer>> ans, int[] candidates, int target, List<Integer> list, int idx){

        if(target == 0){
                ans.add(new ArrayList<>(list));
                return;
            }

        if(idx == candidates.length || target<0){
            return;
        }

        list.add(candidates[idx]);
        backtracking(ans, candidates, target-candidates[idx], list, idx);

        list.remove(list.size()-1);

        backtracking(ans, candidates, target, list, idx+1);
    }
}