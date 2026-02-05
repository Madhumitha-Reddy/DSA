class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> list = new ArrayList<String>();
        addOpe(num, target, 0, 0, 0,"",list);
        return list;
    }

    public void addOpe(String num, int target,int index,long value, long prev, String ds, List<String> list){
        
        if(index == num.length()){
            if(value == target){
                list.add(ds);
            }
            return;
        }
       
        for(int i = index; i<num.length(); i++){
            
            long curr = Long.parseLong(num.substring(index, i + 1));
            if(i > index && num.charAt(index) == '0'){
                break;
            }
            if(index == 0){
                addOpe(num, target, i + 1, curr, curr, ds + curr, list);
            }else{
                addOpe(num, target, i + 1, value + curr, curr, ds+ "+" + curr, list);
                addOpe(num, target, i + 1, value - curr, -curr,ds+ "-" + curr, list);
                addOpe(num, target, i + 1, value - prev + prev * curr, prev * curr, ds + "*" + curr, list);
            }
        }
    }
}