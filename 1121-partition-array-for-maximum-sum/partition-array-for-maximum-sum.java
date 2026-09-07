class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return helper(0, arr, k, n, dp);
    }

    int helper(int index,int[] arr, int k, int n, int[] dp){
        if(index == n){
            return 0;
        }

        if(dp[index] != -1){
            return dp[index];
        }

        int maxAns = 0;
        int maxi = Integer.MIN_VALUE;
        int len = 0;
        int sum = 0;
        for(int i = index; i<Math.min(n, index + k); i++){
            len++;
            maxi = Math.max(maxi, arr[i]);
            sum = (len * maxi) + helper(i + 1, arr, k, n, dp);
            maxAns = Math.max(sum, maxAns);
        }

        return dp[index] = maxAns;
    }
}