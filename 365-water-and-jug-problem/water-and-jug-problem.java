class Solution {
   public boolean canMeasureWater(int x, int y, int target) {
        if(x+y < target)return false;
        while(y != 0){
            int temp = y;
            y = x % y;
            x = temp;
        }
        int gcd = x;
        System.out.println(gcd);
        if(gcd == 1){
            return true;
        }
        if(target % x == 0){
            return true;
        }

        return false;
    } 
}