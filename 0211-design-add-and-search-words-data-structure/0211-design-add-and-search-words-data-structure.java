class WordDictionary {
    class TrieNode{
        TrieNode[] children;
        boolean endOfWord;
        public TrieNode() {
            children=new TrieNode[26];
            endOfWord=false;
        }
    }
    TrieNode root=new TrieNode();
    public void addWord(String word) {
        TrieNode curr=root;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            if(curr.children[idx]==null){
                curr.children[idx]=new TrieNode();
            }
            if(i==word.length()-1){
                curr.children[idx].endOfWord=true;
            }   
            curr=curr.children[idx];
        }
    }
    
    public boolean search(String word) {
        return searchHelper(word,root,0);
    }
    public boolean searchHelper(String word,TrieNode curr,int idx){
        if(idx==word.length()){
            return curr.endOfWord;
        }
        char ch=word.charAt(idx);
        if(ch=='.'){
            for(TrieNode child:curr.children){
                if(child!=null && searchHelper(word,child,idx+1)){
                    return true;
                }
            }
            return false;
        }
        else{
            int childIdx=ch-'a';
            if(curr.children[childIdx]==null){
                return false;
            }
            return searchHelper(word,curr.children[childIdx],idx+1);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
