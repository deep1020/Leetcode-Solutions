class Solution {
    public String reverseWords(String s) {
        String words[]=s.split("\\s+");
        StringBuilder ans=new StringBuilder();
        for(int i=words.length-1;i>=0;i--){
            ans.append(words[i]);
            ans.append(" ");
        }
        return ans.toString().trim();
    }
}
// T.C -> O(n)
// S.C -> O(n)