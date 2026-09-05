class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][k+1];
        for (int[][] arr : dp) {
            for (int[] row : arr) {
                Arrays.fill(row, -1);
            }
        }
        return helper(0, 1, k, prices, n, dp);
    }

    int helper(int index, int buy, int k, int[] prices, int n, int[][][] dp){
        if(index == n){
            return 0;
        }
        if(dp[index][buy][k] != -1){
            return dp[index][buy][k];
        }

        if(k == 0){
            return 0;
        }
        int profit = 0;

        if(buy == 1){
            // buy
            profit = Math.max(-prices[index] + helper(index + 1, 0, k, prices, n, dp),
            // dont buy
            helper(index + 1, 1, k, prices, n, dp));
        }else{
            // sell
            profit = Math.max(prices[index] + helper(index + 1, 1, k - 1, prices, n, dp),
            // dont sell
            helper(index + 1, 0, k, prices, n, dp));
        }

        return dp[index][buy][k] = profit;
    }
}