import java.util.Stack;

class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch == ')'){
                String temp = "";
                while(st.peek() != '('){
                    temp += st.pop();
                }

                st.pop();

                for(char c : temp.toCharArray()){
                    st.push(c);
                }
            }else{
                st.push(ch);
            }
        }

        String result = "";
        for(char c : st){
            result += c;
        }

        return result;
    }
}