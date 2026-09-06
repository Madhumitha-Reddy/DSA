class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<Integer>[][] dp = new ArrayList[n][n + 1];
       
        return helper(0, -1, nums, n, dp);
    }

    List<Integer> helper(int index, int prev_index, int[] nums, int n, List<Integer>[][] dp){
        if(index == n){
            return new ArrayList<>();
        }

        if(dp[index][prev_index + 1] != null){
            return dp[index][prev_index + 1];
        }

        List<Integer> notTake = helper(index + 1, prev_index, nums, n, dp);

        List<Integer> take = new ArrayList<>();
        if(prev_index == -1 || nums[index] % nums[prev_index] == 0){
            take.add(nums[index]);
            List<Integer> remaining = helper(index + 1, index, nums, n, dp);
            take.addAll(remaining);
        }

        if (take.size() > notTake.size()) {
            dp[index][prev_index + 1] = take;
        }else{
            dp[index][prev_index + 1] = notTake;
        }

        return dp[index][prev_index + 1];
    }
}