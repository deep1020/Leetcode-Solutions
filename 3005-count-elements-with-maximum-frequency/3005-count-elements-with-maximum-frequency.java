class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num:nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int count=0;
        int maxFreq=Integer.MIN_VALUE;
        for (int freq:map.values()) {
            maxFreq=Math.max(maxFreq,freq);
        }
        for(int freq:map.values()){
            if(freq==maxFreq){
                count+=maxFreq;
            }
        }
        return count;
    }
}
// T.C -> O(n)
// S.C -> O(n)

// corner case:
// Input: nums = [10,12,11,9,6,19,11]
// Output: 6   considering {10,12,9,6,19} as well that are not maxFreq
// Exected Output: 2 