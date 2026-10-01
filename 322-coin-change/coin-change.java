class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for(int[] num : dp){
            Arrays.fill(num, -1);
        }
        int ans = helper(n - 1, coins, amount, dp);
        if(ans == Integer.MAX_VALUE){
            return -1;
        }
        return ans;
    }

    int helper(int index, int[] coins, int amount, int[][] dp){
        if(amount == 0){
            return 0;
        }

        if(index < 0){
            return Integer.MAX_VALUE;
        }

        if(coins.length == 1){
            if(amount % coins[index] == 0){
                return amount / coins[index];
            }

            return -1;
        }

        if(dp[index][amount] != -1){
            return dp[index][amount];
        }
        int take = Integer.MAX_VALUE;
        int notTake = Integer.MAX_VALUE;
        if(coins[index] <= amount){
            take = helper(index, coins, amount - coins[index], dp);
            if(take != -1 && take != Integer.MAX_VALUE){
                take++;
            }
        }
        notTake = helper(index - 1, coins, amount, dp);

        return dp[index][amount] = Math.min(take, notTake);
    }
}