class Solution {
    public boolean canAliceWin(int[] nums) {
        int sum1 = 0;
        int sum2 = 0;
        for(int i=0; i<nums.length; i++){
            int n = nums[i];
            int count = 0;
            if(n == 0){
                count = 1;
            }
            while (n > 0){
                count++;
                n /= 10;
            }

            if(count == 1){
                sum1 += nums[i];
            }else{
                sum2 += nums[i];
            }
        }

        if(sum1 > sum2 || sum1 < sum2){
            return true;
        }
        return false;
        
    }
}