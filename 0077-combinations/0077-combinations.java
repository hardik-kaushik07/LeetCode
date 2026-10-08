class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(n, k, ans, new ArrayList<>(), 1);
        return ans;
    }

    public void solve(int n, int k, List<List<Integer>> ans, List<Integer> list, int idx){
        if(list.size() == k){
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i = idx; i <= n; i++){
            list.add(i);
            solve(n, k, ans, list, i+1);

            list.remove(list.size()-1);
        }
    }
}