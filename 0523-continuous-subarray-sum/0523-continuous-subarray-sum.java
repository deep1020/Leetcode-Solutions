class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int mod=0;
        for(int i=0;i<nums.length;i++){
            mod=(mod+nums[i])%k;
            if(map.containsKey(mod)){
                if(i-map.get(mod)>1){
                    return true;
                }
            }
            else{
                map.put(mod,i);
            }
        }
        return false;
    }
}
// T.C -> O(n) Iterate through array once takes n time
// S.C -> O(n) Insert key-value pair in HashMap require n space
// Return true if mod should be 0 and we have to take atleast two elements in a window.