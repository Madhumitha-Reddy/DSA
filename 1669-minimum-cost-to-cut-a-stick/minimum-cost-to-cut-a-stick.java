class Solution {
    public int minCost(int n, int[] cuts) {
        int m = cuts.length;
        int[] c = new int[m + 2];
        c[0] = 0;
        c[m + 1] = n;
        for(int i = 0; i < m; i++){
            c[i + 1] = cuts[i]; 
        }
        int[][] dp = new int[m + 1][m + 1];
        for(int[] num : dp){
            Arrays.fill(num, -1);
        }
        Arrays.sort(c);
        return helper(1, m, c, dp);
    }

    int helper(int i, int j, int[] c, int[][] dp){
        if(i > j){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int ans = Integer.MAX_VALUE;
        int cost = c[j + 1] - c[i - 1];
        for(int k = i; k <= j; k++){
            int left = helper(i, k - 1, c, dp);
            int right = helper(k + 1, j, c, dp);
            ans = Math.min(ans, left + right + cost);
        }

        return dp[i][j] = ans;
    }
}