class Solution {
    public boolean lemonadeChange(int[] bills) {
        int countFive = 0;
        int countTens = 0;
        for(int i=0; i<bills.length; i++){
            if(bills[i] == 5){
                countFive++;
            }

            else if(bills[i] == 10){
                if(countFive >= 1){
                    countFive--;
                    countTens++;
                }else{
                    return false;
                }                
            }
            
            else if (bills[i] == 20){
                if(countTens >= 1 && countFive >= 1){
                    countTens--;
                    countFive--;
                }
                else if(countFive >= 3){
                    countFive -= 3;
                }else{
                    return false;
                }
            }
        }

        return true;
    }
}