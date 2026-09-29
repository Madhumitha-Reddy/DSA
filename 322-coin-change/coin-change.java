class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        for(int[] num : dp){
            Arrays.fill(num, -1);
        }
        int ans = helper(n - 1, coins, amount, 0, dp);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    int helper(int index, int[] coins, int amount, int sum, int[][] dp){
        if(sum == amount){
            return 0;
        }
        if(sum > amount || index < 0){
            return Integer.MAX_VALUE;
        }

        if(dp[index][sum] != -1){
            return dp[index][sum];
        }

        int take = helper(index, coins, amount, sum + coins[index], dp);
        if(take != Integer.MAX_VALUE){
            take = take + 1;
        }
        int notTake = helper(index - 1, coins, amount, sum, dp);

        return dp[index][sum] = Math.min(take, notTake);
    }
}