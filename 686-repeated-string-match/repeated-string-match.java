class Solution {
    public int repeatedStringMatch(String a, String b) {
        String concate = "";
        int count = 0;
        while(concate.length() < b.length()){
            concate = concate + a;
            count++;
        }

        if(concate.contains(b)){
            return count;
        }

        concate = concate + a;
        count++;

        if(concate.contains(b)){
            return count;
        }

        return -1;
    }
}