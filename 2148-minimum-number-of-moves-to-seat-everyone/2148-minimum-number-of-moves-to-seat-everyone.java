class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        int pos[]=new int[101];
        for(int i=0;i<seats.length;i++){
            pos[seats[i]]++;
            pos[students[i]]--;
        }
        int moves=0;
        int current=0;
        for(int i:pos){
            moves+=Math.abs(current);
            System.out.println(moves);
            current+=i;
        }
        return moves;
    }
}
// T.C -> O(n+m) Iterate through both seats and students takes O(2n) and then iterate through pos array to calculate number of moves needed to seat students take O(m)
// S.C -> O(m) pos array takes space O(m)