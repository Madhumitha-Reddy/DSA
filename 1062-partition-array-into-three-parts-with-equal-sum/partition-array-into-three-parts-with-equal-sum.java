class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int sum = 0;

        for(int i=0; i<arr.length; i++){
            sum = sum + arr[i];
        }
        if(sum % 3 != 0)return false;


        int count = 0;
        int val = sum / 3;
        int sum2 = 0;

        for(int j=0; j<arr.length; j++){
            sum2 += arr[j];
            if(sum2 == val){
                count++;
                sum2 =0;
            }
        }
        if(count >= 3)return true;
        return false;
        
    }
}