class Solution {
    public boolean isHappy(int n) {
         for (int i = 0; i < 100; i++) {
            n = digitSquareSum(n);
            if (n == 1) return true;   // happy number
        }
        return false;  // if not 1 after many iterations → not happy
    }

    private int digitSquareSum(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit; // basic math only
            n /= 10;
        }
        return sum;
    }
}