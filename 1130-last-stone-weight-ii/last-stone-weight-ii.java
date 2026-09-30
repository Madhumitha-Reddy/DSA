class Solution {
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int totalSum = 0;
        for(int num : stones){
            totalSum += num;
        }

        int[][] dp = new int[n + 1][totalSum];
        for(int[] num : dp){
            Arrays.fill(num, -1);
        }

        return helper(n - 1, 0, stones, totalSum, dp);
    }

    int helper(int index, int sum, int[] stones, int totalSum, int[][] dp){
        if(index < 0){
            int sum2 = totalSum - sum;
            int diff = Math.abs(sum2 - sum);
            return diff;
        }

        if(dp[index][sum] != -1){
            return dp[index][sum];
        }
        int take = helper(index - 1, sum + stones[index], stones, totalSum, dp);
        int notTake = helper(index - 1, sum, stones, totalSum, dp);

        return dp[index][sum] = Math.min(take, notTake);

    }
}