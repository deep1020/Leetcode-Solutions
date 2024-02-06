class Trie {
    class TrieNode{ // Need to create a new class as it prevents from StackOverflowError
        TrieNode[] children;
        boolean endOfWord;
        public TrieNode() {
            children=new TrieNode[26];
            endOfWord=false;
        }
    }
    TrieNode root=new TrieNode();
    public void insert(String word) {
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
        TrieNode curr=root;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            if(curr.children[idx]==null){
                return false;
            }
            if(i==word.length()-1 && curr.children[idx].endOfWord==false){
                return false;
            }
            curr=curr.children[idx];
        }
        return true;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr=root;
        for(int i=0;i<prefix.length();i++){
            int idx=prefix.charAt(i)-'a';
            if(curr==null){
                return false;
            }
            if(curr.children[idx]==null){
                return false;
            }
            curr=curr.children[idx];
        }
        return true;
    }
}
// Corner case:
// Input
// ["Trie","startsWith"]
// [[],["a"]]
// Output: [null,true]
// Expected: [null,false]

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */