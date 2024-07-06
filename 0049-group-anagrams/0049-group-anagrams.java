class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        for(String word:strs){
            char ch[]=word.toCharArray();
            Arrays.sort(ch);
            String sortedWord=new String(ch);
            if(!map.containsKey(sortedWord)){
                List<String> wordList=new ArrayList<>();
                map.put(sortedWord,wordList);
            }
            map.get(sortedWord).add(word);
        }
        return new ArrayList<>(map.values());
    }
}
// T.C -> O(nlogm) n= length of strs logm= sort each string
// S.C -> O(nm) store sortedWord and wordList in ArrayList

// strs = ["eat","tea","tan","ate","nat","bat"]
// sort characters of all string 
// sortedWord: "aet","aet","ant","aet","ant","abt"
// aet -> eat, tea, ate
// ant -> nat
// abt -> bat 
// key-value pair: ["eat","tea","ate"],["bat"],["tan","nat"]
// It doesn't store sortedWord in value of Map. It stores wordList in value of Map and return in a form of ArrayList