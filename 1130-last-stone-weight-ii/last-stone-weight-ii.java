class Solution {
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int sum = 0;
       
        for(int i=0; i<n; i++){
            sum += stones[i];
        }
        int[][] dp = new int[n][2 * sum + 1];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }
        return helper(0, 0, stones, dp, sum);

    }

    int helper(int index, int difference, int[] stones, int[][] dp, int sum){
     
        if(index == stones.length){
            return Math.abs(difference);
        }

        int shiftedDifference = sum + difference;
        if(dp[index][shiftedDifference] != -1){
            return dp[index][shiftedDifference];
        }

      
        int take = helper(index + 1, difference + stones[index], stones, dp, sum);
        int notTake = helper(index + 1, difference - stones[index], stones, dp, sum);

        return dp[index][shiftedDifference] = Math.min(take, notTake);
    }
}