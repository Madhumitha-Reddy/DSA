class Solution {
    public int countDigits(int num) {
        int count=0, last=0, number = num;
        while(num > 0){
            last = num % 10;
            if(number % last == 0){
                count = count + 1;
            }
           
            num = num / 10;
        }
        return count;
    }
}