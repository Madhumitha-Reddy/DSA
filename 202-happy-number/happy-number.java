class Solution {
    public boolean isHappy(int n) {
         for (int i = 0; i < 100; i++) {
            n = digitSquareSum(n);
            if (n == 1) return true; 
        }
        return false;  
    }

    private int digitSquareSum(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit; 
            n /= 10;
        }
        return sum;
    }
}