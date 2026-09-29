class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        for(int[] num : dp){
            Arrays.fill(num, -1);
        }
        return helper(0, 1, prices, fee, dp);
    }
    int helper(int index, int buy, int[] prices, int fee, int[][] dp){

        if(index == prices.length){
            return 0;
        }

        if(dp[index][buy] != -1){
            return dp[index][buy];
        }

        int profit = 0;

        if(buy == 1){
            int take = -prices[index] + helper(index + 1, 0, prices, fee, dp);
            int notTake = 0 + helper(index + 1, 1, prices, fee, dp);
            profit = Math.max(take, notTake);
        }else{
            int take = prices[index] - fee + helper(index + 1, 1, prices, fee, dp);
            int notTake = 0 + helper(index + 1, 0, prices, fee, dp);
            profit = Math.max(take, notTake);
        }

        return dp[index][buy] = profit;
    }
}