class Solution {
    public int lengthOfLastWord(String s) {
        int count = 0;
        String newString = s.trim();
        for(int i=newString.length() - 1; i >= 0; i--){

            if(newString.charAt(i) != ' '){
                count++;
            }else{
                break;
            }
        }
        return count;
    }
}