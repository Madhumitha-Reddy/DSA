class Solution {
    public void sortColors(int[] nums) {

        int i = 0;


        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }

        int k = nums.length - 1;


        for (int j = nums.length - 1; j >= i; j--) {
            if (nums[j] == 2) {
                int temp = nums[k];
                nums[k] = nums[j];
                nums[j] = temp;
                k--;
            }
        }
    }
}