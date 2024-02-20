class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> wordCounts=new HashMap<>();
        for(String word:words){
            wordCounts.put(word,wordCounts.getOrDefault(word,0)+1);
        }
        List<String> uniqueWords=new ArrayList<>(wordCounts.keySet());
        // Sort the words based on frequencies and lexicographical order.
        Collections.sort(uniqueWords,(a,b)->{
            int freqCompare=wordCounts.get(b).compareTo(wordCounts.get(a));
            if(freqCompare==0){
                return a.compareTo(b);
            }
            return freqCompare;
        });
        // Take the top k frequent words.
        return uniqueWords.subList(0, k);
    }
}

// T.C -> O(nlogk) HashMap to count the frequency of each word in the input array, which takes O(n) time and
// sort method takes O(logk) time.
// S.C -> O(n) store the frequency map, which can have at most n entries if all the words are unique

// Either 1st or 2nd test case fail:

// Map<String, Integer> wordCounts=new HashMap<>();
// for(String word:words){
//     wordCounts.put(word,wordCounts.getOrDefault(word,0)+1);
// }
// Queue<String> minHeap=new PriorityQueue<>((a,b)->{
//     int str1_count=wordCounts.get(a);
//     int str2_count=wordCounts.get(b);
//     if(str1_count==str2_count){
//         return a.compareTo(b);
//     }
//     return str1_count-str2_count;
// });
// for(String word:wordCounts.keySet()){
//     minHeap.offer(word);
//     if(minHeap.size()>k){
//         minHeap.poll();
//     }
// }
// List<String> list=new LinkedList<>();
// while(!minHeap.isEmpty()){
//     list.add(minHeap.poll());
// }
// return list;