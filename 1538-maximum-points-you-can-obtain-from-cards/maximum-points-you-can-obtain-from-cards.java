class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int sum = 0;
        int left = 0;
        int right = n - k;
        int max = 0;
        for(int i=0; i<n - k; i++){
            sum += cardPoints[i];
        }

        int total = 0;
        for(int num : cardPoints){
            total += num;
        }

        max = total - sum;
        for(int i=n - k; i<n; i++){
            sum += cardPoints[i];
            sum -= cardPoints[left];
            left++;

            max = Math.max(max, total - sum);
        }

        return max;
    }
}