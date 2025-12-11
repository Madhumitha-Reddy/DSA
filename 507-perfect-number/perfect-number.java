class Solution {
    public boolean checkPerfectNumber(int num) {
        int sum = 0;
        int number = num/2;
       
        for(int i=1; i<=number; i++){
            if(num % i == 0){
                sum = sum + i;
            }
        }
        
        if(sum == num){
            return true;
        }else{
            return false;
        }
    }
}