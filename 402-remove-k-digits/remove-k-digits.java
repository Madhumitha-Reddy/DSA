class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        for(int i=0; i<num.length(); i++){
            char c = num.charAt(i);
            while(!st.isEmpty() && k>0 && st.peek() > c){
                st.pop();
                k--;
            }
            st.push(c);
        }
        while(k>0 && !st.isEmpty()) {
            st.pop();
            k--;
        }
        StringBuilder res = new StringBuilder();
        for (char c : st) {
            res.append(c);
        }
        while (res.length() > 0 && res.charAt(0) == '0') {
            res.deleteCharAt(0);
        }
        if(res.isEmpty()) return "0";
        return res.toString();
    }
}