class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        int max = 0;
        for (int r = 0; r <= 2 * (n - 1); r++) {
            for (int c = 0; c <= 2 * (n - 1); c++) {
                int row = r - (n - 1);
                int col = c - (n - 1);
                int count = 0;

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        int x = i + row;
                        int y = j + col;

                        if (x >= 0 && x < n && y >= 0 && y < n) {
                            if (img1[i][j] == 1 &&
                                img2[x][y] == 1) {
                                count++;
                            }
                        }
                    }
                }

                max = Math.max(max, count);
            }
        }

        return max;
    }
}