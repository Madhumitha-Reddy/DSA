class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][3];
        for(int[][] num : dp){
            for(int[] row : num){
                Arrays.fill(row, -1);
            }
        }
        return helper(0, 1, prices, 2, dp);
    }

    int helper(int index, int buy, int[] prices, int k, int[][][] dp){
        if(index == prices.length){
            return 0;
        }

        if(k == 0){
            return 0;
        }

        if(dp[index][buy][k] != -1){
            return dp[index][buy][k];
        }
        int profit = 0;


        if(buy == 1){
            int take = -prices[index] + helper(index + 1, 0, prices, k, dp);
            int notTake = 0 + helper(index + 1, 1, prices, k, dp);
            profit = Math.max(take, notTake);
        }else{
            int take = prices[index] + helper(index + 1, 1, prices, k - 1, dp);
            int notTake = 0 + helper(index + 1, 0, prices, k, dp);
            profit = Math.max(take, notTake);
        }
        

        return dp[index][buy][k] = profit;
    }
}