class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[][] dp = new int[m][m];
        for(int[] num : dp){
            Arrays.fill(num, Integer.MAX_VALUE);
        }
        return helper(0, 0, m, triangle, dp);
    }

    int helper(int row, int col, int m, List<List<Integer>> triangle, int[][] dp){
        if(row == m - 1){
            return triangle.get(row).get(col);
        }

        if(dp[row][col] != Integer.MAX_VALUE){
            return dp[row][col];
        }
        int min = Integer.MAX_VALUE;

        int below = triangle.get(row).get(col) + helper(row + 1, col, m, triangle, dp);
        int diagRight = triangle.get(row).get(col) + helper(row + 1, col + 1, m, triangle, dp);
    

        min = Math.min(below, diagRight);
        return dp[row][col] = min;
    }
}