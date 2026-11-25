class Solution {
    // Normal Recursion: 
    // public int fib(int n) {
    //     if(n == 0 || n == 1) return n;
    //     return fib(n-1) + fib(n-2);
    // }

    // Using DP:
    static int[] dp;
    public int fib(int n) {
        dp = new int[n+1];
        return dp(n);
    }
    public int dp(int n){
        if(n<=1) return n;
        if(dp[n]!=0) return dp[n];
        int ans = dp(n-1) + dp(n-2);
        dp[n] = ans;
        return ans;

    }
}