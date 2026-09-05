class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] num : dp){
            Arrays.fill(num, -1);
        }
        return helper(0, 1, prices, n, dp);       
    }

    int helper(int index, int buy, int[] prices, int n, int[][] dp){
        if(index == n){
            return 0;
        }
        if(dp[index][buy] != -1){
            return dp[index][buy];
        }
        int profit = 0;
        if(buy == 1){
            // buy
            profit = Math.max(-prices[index] + helper(index + 1, 0, prices, n, dp),
            // dont buy
            helper(index + 1, 1, prices, n, dp));
        }else{
            // sell
            profit = Math.max(prices[index] + helper(index + 1, 1, prices, n, dp), 
            // dont sell
            helper(index + 1, 0, prices, n, dp));
        }

        return dp[index][buy] = profit;
    }
}