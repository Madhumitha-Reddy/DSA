class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;

        if(n == 0){
            return 0;
        }
        
        int[] arr = new int[n];
        int j = 0;
        int count = 0;
        for(int i = 0; i < n - 1; i++){
            if(nums[i] != nums[i + 1]){
                arr[j] = nums[i];
                j++;
                count++;
            }
        }

        arr[j] = nums[n - 1];
        count++;

        for(int i = 0; i < count; i++){
            nums[i] = arr[i];
        } 

        return count;                     
    }
}