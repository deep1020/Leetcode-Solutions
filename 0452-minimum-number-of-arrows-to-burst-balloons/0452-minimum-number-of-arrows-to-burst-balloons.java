class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points.length<2){
            return points.length;
        }
        Arrays.sort(points, (a,b)->Integer.compare(a[0],b[0]));
        int arrows_end=points[0][1];
        int min_arrows=1;
        for(int i=1;i<points.length;i++){
            if(points[i][0]>arrows_end){
                min_arrows++;
                arrows_end=points[i][1];
            }
            arrows_end=Math.min(arrows_end,points[i][1]);
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
// arrows_end= points[0][1]= 6
// For i=0 -> points[0][0]=1>0 then min_arrows=1 and arrows_end= points[0][1]= 6
// For i=1 -> points[1][0]=2>6 No
// For i=2 -> points[2][0]=7>6 then min_arrows=2 and arrows_end= points[2][1]= 12
// For i=3 -> points[3][0]=10>12 No
// return min_arrows=2

// corner case: arrows_end= Math.min(arrows_end,points[i][1]);
// corner case for negative value of points[0], ex: points = [[-1,1],[0,1],[2,3],[1,2]]
// if(min_arrows==0), it also increments min_arrows
