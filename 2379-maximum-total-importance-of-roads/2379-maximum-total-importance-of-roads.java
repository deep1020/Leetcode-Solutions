class Solution {
    public long maximumImportance(int n, int[][] roads) {
        long freq[]=new long[n+1];
        for(int road[]:roads){
            freq[road[0]]++;
            freq[road[1]]++;
        }
        Arrays.sort(freq);
        long ans=0;
        for(long i=1;i<=n;i++){
            ans+=i*freq[(int)i];
            System.out.println(ans);
        }
        return ans;
    }
}

// T.C -> O(nlogn+m), where n= number of nodes and m= number of edges
// S.C -> O(n) storing freq array

// Dry run:
// Step 1: Initialize frequency array
// n = 5, roads = [[0, 1], [1, 2], [2, 3], [0, 2], [1, 3], [2, 4]]
// Initialize freq = [0, 0, 0, 0, 0, 0]
// Step 2: calculate freqency of each node
// road [0, 1] -> freq = [1, 1, 0, 0, 0, 0]
// road [1, 2] -> freq = [1, 2, 1, 0, 0, 0]
// road [2, 3] -> freq = [1, 2, 2, 1, 0, 0]
// road [0, 2] -> freq = [2, 2, 3, 1, 0, 0]
// road [1, 3] -> freq = [2, 3, 3, 2, 0, 0]
// road [2, 4] -> freq = [2, 3, 4, 2, 1, 0]
// sort freq= [0, 1, 2, 2, 3, 4]
// Initialize ans=0
// Loop through sorted freq array from 1 to n:
// For i = 1: ans = 1 * freq[1] = 1 * 1 = 1
// For i = 2: ans = 1 + 2 * freq[2] = 1 + 2 * 2 = 5
// For i = 3: ans = 5 + 3 * freq[3] = 5 + 3 * 2 = 11
// For i = 4: ans = 11 + 4 * freq[4] = 11 + 4 * 3 = 23
// For i = 5: ans = 23 + 5 * freq[5] = 23 + 5 * 4 = 43