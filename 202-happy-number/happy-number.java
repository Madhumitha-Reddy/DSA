class Solution {
    public boolean isHappy(int n) {
         for (int i = 0; i < 100; i++) {
            n = SquareSum(n);
            if (n == 1) return true; 
        }
        return false;  
    }

    public int SquareSum(int n) {
        int sum = 0;
        while (n > 0) {
            int last = n % 10;
            sum += last * last; 
            n /= 10;
        }
        return sum;
    }
}