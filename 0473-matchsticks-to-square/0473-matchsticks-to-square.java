class Solution {
    public boolean makesquare(int[] matchsticks) {
        int total = 0;
        for(int  i = 0; i < matchsticks.length; i++){
            total += matchsticks[i];
        }

        if(total % 4 != 0){
            return false;
        }

        
        Arrays.sort(matchsticks);
        if(matchsticks[matchsticks.length-1] > total/4){
            return false;
        }
        int[] sides = new int[4];
        return solve(matchsticks, sides, total/4, matchsticks.length-1);
    }

    public boolean solve(int[] matchsticks, int[] sides, int target, int idx){
        if (idx < 0) {
            return true;
        }

        for(int i = 0; i < 4; i++){
            if(sides[i]+matchsticks[idx] <= target){
                sides[i] += matchsticks[idx];
                if(solve(matchsticks, sides, target, idx-1)){
                    return true;
                }
                sides[i] -= matchsticks[idx];
            }
        }
        return false;
    }
}