class Solution {
    public int countGoodNumbers(long n) {
        int mod = 1_000_000_007;
        long even = (n + 1) / 2;
        long odd = n / 2;
        long evenPart = helper(5, even, mod);
        long oddPart = helper(4, odd, mod);
        return (int)((evenPart * oddPart) % mod);
    }

    public long helper(long base, long exp, long mod){
        long res = 1;
        while(exp > 0){
            if ((exp & 1) == 1){
                res = (res * base) % mod;
            }
            base = (base * base) % mod;
            exp >>=1;
        }
        return res;
    }
}