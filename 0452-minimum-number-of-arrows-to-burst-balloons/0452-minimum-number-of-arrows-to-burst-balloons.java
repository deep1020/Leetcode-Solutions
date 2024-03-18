class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points.length<2){
            return points.length;
        }
        Arrays.sort(points, (a,b)->Integer.compare(a[1],b[1]));
        int arrows_end=0;
        int min_arrows=0;
        for(int i=0;i<points.length;i++){
            if(points[i][0]>arrows_end || min_arrows==0){
                min_arrows++;
                arrows_end=points[i][1];
            }
        }
        return min_arrows;
    }
}
// T.C -> O(nlogn)
// S.C -> O(1)

// Dry run
// sort based on end point -> [1,6],[2,8],[7,12],[10,16]
// points[i][0] -> {1,2,7,10}
// points[i][1] -> {6,8,12,16}
// For i=0 -> points[0][0]=1>0 then min_arrows=1 and arrows_end=6
// For i=1 -> points[1][0]=2>6 No
// For i=2 -> points[2][0]=7>6 then min_arrows=2 and arrows_end=12
// For i=3 -> points[3][0]=10>12 No
// return min_arrows=2

// corner case for negative value of points[0], ex: points = [[-1,1],[0,1],[2,3],[1,2]]
// if(min_arrows==0), it also increments min_arrows
