class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int minBoats=0;
        int left=0;
        int right=people.length-1;
        while(left<=right){
            if(people[left]+people[right]<=limit){
                left++;
            }
            right--;
            minBoats++;
        }
        return minBoats;
    }
}
// Two pointer approach
// T.C -> O(nlogn) sorting array takes O(nlogn) time and two-pointer approach takes O(n)
// S.C -> O(1) variables (minBoats,left,right) takes O(1) space. No additional space required