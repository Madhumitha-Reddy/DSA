class Solution {

    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private int atMost(int[] nums, int k) {
        int l=0;
        int r=0;
        int sum=0;
        int count=0;
        while(r < nums.length){
            sum = sum + nums[r] % 2;
            while(sum > k){
                sum = sum - nums[l] % 2;
                l++;
            }
            count = count + (r-l+1);
            r++;
        }
        return count;
    }
}