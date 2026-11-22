class Solution {
    public boolean judgeSquareSum(int c) {
        int n = (int)Math.sqrt(c);
        int i = 0, j = n;
        while(i<=j){
            long sum = (long)i*i + (long)j*j;
            if(sum == c){
                return true;
            }
            else if(sum < c){
                i++;
            }
            else{
                j--;
            }
        }
        return false;
    }
}