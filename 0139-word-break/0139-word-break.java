class Solution {
    class Node{
        Node[] children;
        boolean endOfWord;
        Node(){
            children=new Node[26];
            for(int i=0;i<26;i++){
                children[i]=null;
            }
            endOfWord=false;
        }
    }
    Node root=new Node();
    void insert(String word){
        Node curr=root;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            if(curr.children[idx]==null){
                curr.children[idx]=new Node();
            }
            if(i==word.length()-1){
                curr.children[idx].endOfWord=true;
            }
            curr=curr.children[idx];
        }
    }
    boolean search(String key){
        Node curr=root;
        for(int i=0;i<key.length();i++){
            int idx=key.charAt(i)-'a';
            if(curr.children[idx]==null){
                return false;
            }
            if(i==key.length()-1 && curr.children[idx].endOfWord==false){
                return false;
            }
            curr=curr.children[idx];
        }
        return true;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        for(String word:wordDict){
            insert(word);
        }
        boolean dp[]=new boolean[s.length()+1];
        dp[0]=true;
        for(int i=1;i<=s.length();i++){
            for(int j=0;j<i;j++){
                if(dp[j] && search(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
// T.C -> O(n^2+m*k) trie involves iterating over all characters of all words so it costs O(m*k)
// then calculate dp. For each i, we iterate over indices after i. It cost O(n^2)
// S.C -> O(n+m*k) dp array takes O(n) space and trie can have up to m*k nodes in it.
// Here n= length of s, m= length of wordDict, k= average length of words in wordDict