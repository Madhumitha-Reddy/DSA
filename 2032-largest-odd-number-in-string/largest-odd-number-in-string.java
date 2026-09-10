class Solution {
    public String largestOddNumber(String num) {
        return helper(num, num.length() - 1);
    }

    public String helper(String num, int i){
        if(i < 0){
            return "";
        }

        int digit = num.charAt(i) - '0';
        if(digit % 2 != 0){
            return num.substring(0, i + 1);
        }

        return helper(num, i - 1);
    }
}