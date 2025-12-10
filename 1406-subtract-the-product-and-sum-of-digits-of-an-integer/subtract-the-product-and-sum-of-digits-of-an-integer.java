class Solution {
    public int subtractProductAndSum(int n) {
        int p=1,s=0;
        while(n>0){
            int last=n%10;
            p=p*last;
            s=s+last;
            n=n/10;
        }
        return p-s;
    }
}