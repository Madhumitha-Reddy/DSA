class Solution {
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);

        int[] arr = new int[cuts.length + 2];

        arr[0] = 0;
        arr[cuts.length + 1] = n;

        for(int i=0; i<cuts.length; i++){
            arr[i + 1] = cuts[i];
        }

        int[][] dp = new int[cuts.length + 2][cuts.length + 2];
        for(int[] num : dp){
            Arrays.fill(num, -1);
        }
        return helper(1, cuts.length, arr, dp);
    }

    int helper(int i, int j, int[] cuts, int[][] dp){
        if(i > j){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int mini = Integer.MAX_VALUE;

        for(int k = i; k <= j; k++){
            int cost = cuts[j + 1] - cuts[i - 1] + helper(i, k - 1, cuts, dp) + helper(k + 1, j, cuts, dp);
            mini = Math.min(mini, cost);
        }

        return dp[i][j] = mini;
    } 
}