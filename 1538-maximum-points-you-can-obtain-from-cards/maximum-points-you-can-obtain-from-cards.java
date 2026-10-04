class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int leftSum = 0;
        int rightSum = 0;
        for(int i=0; i<=k-1; i++){
            leftSum += cardPoints[i];
        }

        int maxSum = leftSum;
        int minLen = n - 1;
        for(int i = k - 1; i >= 0; i--){
            leftSum -= cardPoints[i];
            rightSum += cardPoints[minLen];
            minLen -= 1;
            maxSum = Math.max(maxSum, leftSum + rightSum);
        }

        return maxSum;
    }
}