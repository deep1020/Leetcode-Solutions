class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> set=new HashSet<>(dictionary);
        StringBuilder result=new StringBuilder();
        String words[]=sentence.split("\\s+"); // splits the string wherever there are one or more consecutive whitespace characters.
        for(String word:words){
            String prefix="";
            for(int i=1;i<=word.length();i++){
                prefix=word.substring(0,i);
                if(set.contains(prefix)){
                    break;
                }    
            }
            if(result.length()>0){
                result.append(" ");
            }
            result.append(prefix);
        }
        return result.toString();
    }
}
// T.C -> O(k+m+n*l)
// HashSet from the dictionary takes O(k), where k is the number of words in the dictionary.
// m is the length of the sentence as it scans entire sentence to find whitespace characters.
// n is the words in the sentence that we iterate each word in sentence.
// l is the average length of the words in the sentence.
// StringBuilder takes O(1) time on average for each append operation.
// inner loop runs l times for each word, making the total time for the inner operations O(n * l).

// S.C -> O(k+m+n)
// HashSet stores k words from the dictionary
// array words stores up to n words
// StringBuilder holds the final result which takes O(m) space