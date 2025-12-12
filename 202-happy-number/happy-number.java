class Solution {
    public boolean isHappy(int n) {
         for (int i = 0; i < 100; i++) {
            n = squareSum(n);
            if (n == 1) return true; 
        }
        return false;  
    }

    public int squareSum(int n) {
        int sum = 0;
        while (n > 0) {
            int last = n % 10;
            int square = last * last;
            sum += square; 
            n /= 10;
        }
        return sum;
    }
}