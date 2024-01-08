class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list,"",0,0,n);
        return list;
    }
    public void backtrack(List<String> list,String str,int open,int close,int pairs){
        if(str.length()==pairs*2){
            list.add(str);
            return;
        }
        if(open<pairs){
            backtrack(list,str+"(",open+1,close,pairs);
        }
        if(close<open){
            backtrack(list,str+")",open,close+1,pairs);
        }
    }
}