class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int left=0;
        int right=position[position.length-1];
        int ans=-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(isPlaced(mid,position,m)){
                ans=mid;
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return ans;
    }
    private boolean isPlaced(int mid,int position[],int m){
        int prevIndex=0;
        int countBall=1;
        for(int i=1;i<position.length;i++){
            if(position[i]-position[prevIndex]>=mid){
                prevIndex=i;
                countBall++;
            }
        }
        return countBall>=m;
    }
}
// T.C -> O(nlogn+nlogd)
// sort position array takes O(nlogn)
// Binary search runs in O(logd) where d= distance between minimum and maximum position (position[0] and position[position.length-1]) and for each mid point of binary search, isPlaced function is called, which iterates through position array in O(n)
// S.C -> O(logn) we are using only a few extra variables for the binary search and the placement check. sorting step may use additional space depending on the sorting algorithm O(logn) space

// 1) positions array needs to be sorted to facilitate the placement of balls with a given minimum distance.
// 2) left and right bounds for the binary search are initialized. left is 0 (minimum possible distance), and right is the difference between the maximum and minimum positions. Binary search is performed to find the largest minimum distance. The variable ans is used to store the result.
// 3) For each midpoint (mid) calculated during the binary search, the function isPlaced(mid, position, m) is called to check if it is possible to place m balls such that the minimum distance between any two balls is at least mid.
// 4) isPlaced function
// - Attempts to place balls in the sorted positions array. It starts by placing the first ball at the first position
// - It then iterates through the array to place subsequent balls, ensuring that each ball is placed at least mid distance away from the previously placed ball.
// - If m or more balls can be placed with atleast mid distance between them, the function returns true; otherwise, it returns false.