class Solution {
      public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][3];
         for (int[][] arr : dp) {
            for (int[] row : arr) {
                Arrays.fill(row, -1);
            }
        }
        return helper(0, 1, prices, n, 2, dp);       
    }

    int helper(int index, int buy, int[] prices, int n, int trans, int[][][] dp){
        if(index == n){
            return 0;
        }

        if(trans == 0){
            return 0;
        }
        if(dp[index][buy][trans] != -1){
            return dp[index][buy][trans];
        }
        int profit = 0;
        if(buy == 1){
            // buy
            profit = Math.max(-prices[index] + helper(index + 1, 0, prices, n, trans, dp),
            // dont buy
            helper(index + 1, 1, prices, n, trans, dp));
        }else{
            // sell
            profit = Math.max(prices[index] + helper(index + 1, 1, prices, n, trans - 1, dp), 
            // dont sell
            helper(index + 1, 0, prices, n, trans, dp));
        }

        return dp[index][buy][trans] = profit;
    }
}