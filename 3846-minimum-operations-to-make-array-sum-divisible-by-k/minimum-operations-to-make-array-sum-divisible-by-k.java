class Solution {
    public int minOperations(int[] nums, int k) {
        int sum = 0;
        int res = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
        }

        if(sum % k == 0){
            return 0;
        }else{
            res = sum % k; 
        }


        return res;
    }
}