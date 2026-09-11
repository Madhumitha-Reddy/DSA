class Solution {
    public String countAndSay(int n) {
        String first = "1";
        for(int i=1; i<n; i++){
            StringBuilder sb = new StringBuilder();
            int count = 1;

            for(int j = 1; j < first.length(); j++){
                if(first.charAt(j) == first.charAt(j - 1)){
                    count++;
                }else{
                    sb.append(count);
                    sb.append(first.charAt(j - 1));
                    count = 1;
                }
            }
            sb.append(count);
            sb.append(first.charAt(first.length() - 1));
            first = sb.toString();
        }

        return first;
    }
}