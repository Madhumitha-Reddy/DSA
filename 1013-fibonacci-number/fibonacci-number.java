class Solution {
    public int fib(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        int num1 = 0;
        int num2 = 1;
        while(n > 0){
            int curr1 = num1 + num2;
            num1 = num2;
            num2 = curr1;
            n--;
        }
        return num1;
    }
}