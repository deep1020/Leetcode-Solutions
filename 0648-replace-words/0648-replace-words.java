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
    String search(String word){
        Node curr=root;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(curr.children[ch-'a']==null){
                return word;
            }
            curr=curr.children[ch-'a'];
            if(curr.endOfWord){
                return word.substring(0,i+1);
            }
        }
        return word;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        for(String word:dictionary){
            insert(word);
        }
        String words[]=sentence.split(" ");
        StringBuilder sb=new StringBuilder();
        for(String word:words){
            sb.append(search(word));
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}
// Best approach - Trie
// T.C -> O(n*l +m+ w*l)
// Inserting each word into the Trie takes O(l), where l is the length of the word.
// For a dictionary of size n with words of average length L, inserting all words takes O(n*l).
// Splitting the sentence into words takes O(m), where m is the length of the sentence.
// For each word in the sentence, searching in the Trie takes O(l), where l is the length of the word.
// If there are w words in the sentence and each word has an average length of l, the total time for searching is O(w*l).
// S.C -> O(n*l +m)
// Each character in each word results in a new node, giving us a space complexity of O(n*l*26). However, 26 is a constant, this simplifies to O(n*l).
// Space used to store the split words from the sentence is O(m).
// StringBuilder used to construct the final sentence also takes O(m) space.