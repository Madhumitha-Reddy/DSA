class Solution {
    public int minCut(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int[] num : dp){
            Arrays.fill(num, -1);
        }
        return helper(0, s.length() - 1, s, dp);
    }

    int helper(int i, int j, String s, int[][] dp){
        if(i >= j){
            return 0;
        }

        int mini = Integer.MAX_VALUE;

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if (palindrome(i, j, s)) {
            return dp[i][j] = 0;
        }

        int sub = 0;
        for(int k=i; k<j; k++){
            if(palindrome(i, k, s)){
                sub = 1 + helper(k + 1, j, s, dp);
                mini = Math.min(mini, sub);
            }
        }

        return dp[i][j] = mini;
    }
    boolean palindrome(int i, int j, String s){
        if(i >= j){
            return true;
        }

        if(s.charAt(i) != s.charAt(j)){
            return false;
        }

        return palindrome(i + 1, j - 1, s);
    }
}