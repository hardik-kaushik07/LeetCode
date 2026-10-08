class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new  ArrayList<>();
        solve(n, k, ans, new ArrayList<>(), 1);
        return ans;

    }

    public void solve(int n, int k, List<List<Integer>> ans, List<Integer> list, int idx){
        if(list.size() == k && n == 0){
            ans.add(new ArrayList<>(list));
            return;
        }
            for(int i = idx; i <= 9; i++){
                list.add(i);
                solve(n-i, k, ans, list, i+1);

                list.remove(list.size()-1);
             }
    }
}