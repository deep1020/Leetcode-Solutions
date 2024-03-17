class Solution {
    public int minimumDeletions(String word, int k) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : word.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        int min = Integer.MAX_VALUE;
        for (int freq : freqMap.values()) {
            int curr = 0;
            for (int j : freqMap.values()) {
                curr += j < freq ? j : Math.max(0, j - k - freq);
                System.out.println(curr);
            }
            min = Math.min(min, curr);
            System.out.println("Minimum: "+min);
        }
        return min;
    }
}

// 1) Initialize an empty HashMap freqMap to store the frequency of each character.
// 2) Iterate through each character in the word "aabcaba":
// 3) After this loop, freqMap will contain the frequencies: {'a':4,'b':2,'c':1}.
// 4) Initialize min to Integer.MAX_VALUE
// 5) Iterate over the values of freqMap
//    For the first iteration, freq is 4.
//    Initialize curr=0.
// Inner loop: For each frequency j in countMap.values():
// For 'a' (freq = 4), j is 4, then curr += Math.max(0, 4 - 0 - 4) = 0+0 = 0
// For 'b' (freq = 4), j is 2, j<freq then curr += j =  2+0 = 2
// For 'c' (freq = 4), j is 1, j<freq then curr += j = 1+2 = 3
// Min= Math.min(Integer.MAX_VALUE,curr) = 3

// For 'a' (freq = 2) , j is 4, then curr + = Math.max(0, 4-0-2)=2+0=2
// For 'b' (freq = 2) , j is 2, then curr + = Math.max(0, 2-0-2)=0+2=2
// For 'c' (freq = 2), j is 1, j<freq then curr += 1+2 =3
// Min= Math.min(Integer.MAX_VALUE,curr)= Math.min(3,3)= 3
// return 3