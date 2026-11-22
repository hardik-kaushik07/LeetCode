class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for(int val : candies){
            max = Math.max(max, val);
        }
        List<Boolean> ans = new ArrayList<>();
        for(int val : candies){
            if(val + extraCandies >= max){
                ans.add(true);
            }
            else{
                ans.add(false);
            }
        }
        return ans;
    }
}