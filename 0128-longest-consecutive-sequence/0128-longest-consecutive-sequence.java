class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int count=1;
        int longest=0;
        for(int num:nums){
            if(!set.contains(num-1)){
                count=1;
                while(set.contains(num+1)){
                    count++;
                    num++;
                }
            }
            longest=Math.max(longest,count);
        }
        return longest;
    }
}
// T.C -> O(n)
// S.C -> O(n)