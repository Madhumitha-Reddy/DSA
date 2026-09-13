class Solution {
    public boolean validPalindrome(String s) {
        return isPalindrome(s, 0, s.length() - 1);
    }

    boolean isPalindrome(String s, int left, int right){
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                if(palindrome(s, left + 1, right)){
                    return true;
                }

                if(palindrome(s, left, right - 1)){
                    return true;
                }

                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    boolean palindrome(String s, int left, int right){
    
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}