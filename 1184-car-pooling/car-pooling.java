class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] ans = new int[1001];
        for(int[] trip : trips){
            int numPassengers = trip[0];
            int from = trip[1];
            int to = trip[2];
            ans[from] += numPassengers;
            ans[to] -= numPassengers;
        }


        int passengers = 0;

        for(int i=0; i<1001; i++){
            passengers += ans[i];
            if(passengers > capacity){
                return false;
            }
        }
        return true;
    }
}