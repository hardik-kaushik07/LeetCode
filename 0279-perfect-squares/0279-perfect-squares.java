class Solution {
    // Normal Recursion and it will give TLE :
    // public boolean isPerfect(int n){
    //     int sqrt = (int)(Math.sqrt(n));
    //     return (sqrt*sqrt == n);
    // }
    // public int numSquares(int n) {
    //     if(isPerfect(n)) return 1;
    //     int min = Integer.MAX_VALUE;
    //     for(int i = 1; i <= n/2; i++){
    //         int count = numSquares(i) + numSquares(n-i);
    //         min = Math.min(min, count);
    //     }
    //     return min;
    // }

    // Using Memoization:
    // public boolean isPerfect(int n){
    //     int sqrt = (int)(Math.sqrt(n));
    //     return (sqrt*sqrt == n);
    // }
    // public int numSquares(int n) {
    //     int[] dp = new int[n+1];
        
    //     Arrays.fill(dp, -1);
    //     return helper(n, dp);
    // }
    // public int helper(int n, int[] dp){
    //     if(isPerfect(n)) return 1;
    //     if(dp[n] != -1) return dp[n];
    //     int min = Integer.MAX_VALUE;
    //     for(int i = 1; i*i <= n; i++){
    //         int count = helper(i*i, dp) + helper(n-i*i, dp);
    //         min = Math.min(min, count);
    //     }
    //     return dp[n] = min;
    // }

    // Using Tabulation:

    public boolean isPerfect(int n){
        int sqrt = (int)(Math.sqrt(n));
        return (sqrt*sqrt == n);
    }
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        
        for(int i = 1; i <= n; i++){
            if(isPerfect(i)) dp[i] = 1;
            else{
                int min = Integer.MAX_VALUE;
                for(int j = 1; j*j <= i; j++){
            int count = dp[j*j] + dp[i-j*j];
            min = Math.min(min, count);
                }
                dp[i] = min;
            }
        }
        return dp[n];
    }
}