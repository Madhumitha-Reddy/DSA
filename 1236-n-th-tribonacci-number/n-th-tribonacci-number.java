class Solution {
    public int tribonacci(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        int num1 = 0;
        int num2 = 1;
        int num3 = 1;
        while(n > 1){
            int curr = num1 + num2 + num3;
            num1 = num2;
            num2 = num3;
            num3 = curr;
            n--;
        }
        return num2;
    }
}