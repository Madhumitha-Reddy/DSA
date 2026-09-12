class Solution {
    public int minAddToMakeValid(String s) {
        int count1 = 0;
        int count2 = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                count1++;
            }else if(s.charAt(i) == ')'){

                if(count1 > 0){
                    count1--;
                }else{
                    count2++;
                }
            }
        }

        int mini = count1 + count2;

        return mini;

    }
}