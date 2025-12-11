class Solution {
    public int arrangeCoins(int n) {
        int rows = 0;
        int coins = n;

        for (int i = 1; i <= coins; i++) {
            if (coins >= i) {
                coins -= i;
                rows++;
            } else {
                break;
            }
        }

        return rows;
    }
}