class Solution {
    public int countWords(String[] words1, String[] words2) {
        Map<String,Integer> map1=new HashMap<>();
        for(String word:words1){
            if(map1.containsKey(word)){
                map1.put(word,map1.getOrDefault(word,0)+1);
            }
            else{
                map1.put(word,1);
            }
        }
        Map<String,Integer> map2=new HashMap<>();
        for(String word:words2){
            if(map2.containsKey(word)){
                map2.put(word,map2.getOrDefault(word,0)+1);
            }
            else{
                map2.put(word,1);
            }
        }
        int count=0;
        for(String word:words1){ // same for iterate word2 -> for(String word:words2) 
            if(map1.getOrDefault(word,0)==1 && map2.getOrDefault(word,0)==1){
                count++;
            }
        }
        return count;
    }
}
// T.C -> O(n+m) where n= length of word1 and m= length of word2
// first loop iterates over words1 and performs constant time operations for each word O(n) time
// second loop iterates over words2 and performs similar operations O(m) time
// Counting matching words: The third loop iterates over words1 and checks conditions, each taking constant time. 
// S.C -> O(n+m)  In the worst case, the hashmap will store all unique words from words1, taking O(n) space
// Similarly, the hashmap will store all unique words from words2, taking O(m) space