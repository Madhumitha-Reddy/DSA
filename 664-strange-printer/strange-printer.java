class Solution {
    public int strangePrinter(String s) {
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];
        for(int[] num : dp){
            Arrays.fill(num, -1);
        }
        return helper(0, s.length() - 1, s, dp);
    }

    int helper(int i, int j, String s, int[][] dp){
        if(i > j){
            return 0;
        }

        if(i == j){
            return 1;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(s.charAt(i) == s.charAt(j)){
            return helper(i, j - 1, s, dp);
        }

        int mini = Integer.MAX_VALUE;
        for(int k = i; k < j; k++){
            int count = helper(i, k, s, dp) + helper(k + 1, j, s, dp);
            mini = Math.min(mini, count);
        }

        return dp[i][j] =  mini;
    }
}