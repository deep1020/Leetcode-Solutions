class Solution {
    public String reversePrefix(String word, char ch) {
        int chIndex=word.indexOf(ch);
        // Base case
        if(chIndex==-1){
            return word;
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<word.length();i++){
            if(i<=chIndex){
                sb.append(word.charAt(chIndex-i));
            }
            else{
                sb.append(word.charAt(i));
            }
        }
        return sb.toString();
    }
}
// T.C -> O(n)
// S.C -> O(n) 