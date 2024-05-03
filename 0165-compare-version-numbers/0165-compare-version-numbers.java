class Solution {
    public int compareVersion(String version1, String version2) {
        String str1[]=version1.split("\\."); 
        String str2[]=version2.split("\\."); 
        int max=Math.max(str1.length,str2.length);
        for(int i=0;i<max;i++){ 
            int num1= i>=str1.length?0 : Integer.parseInt(str1[i]);
            int num2= i>=str2.length?0 : Integer.parseInt(str2[i]);
            if(num1<num2){
                return -1;
            }
            if(num1>num2){
                return 1;
            }
        }
        return 0;
    }
}
// T.C -> O(n)
// S.C -> O(n)

// compares two version strings (version1 and version2) by splitting them into arrays of version components using dot (.) as a delimiter. It then iterates over these arrays, comparing each corresponding component
// Iterates over the indices of the arrays from 0 up to the maximum length.
// int num1 = i >= str1.length ? 0 : Integer.parseInt(str1[i]): Parses the integer value at index i of str1 if i is within the bounds of str1, otherwise defaults to 0.
// int num2 = i >= str2.length ? 0 : Integer.parseInt(str2[i]): Parses the integer value at index i of str2 if i is within the bounds of str2, otherwise defaults to 0.
// If a component in version1 is less than the corresponding component in version2, it returns -1 indicating version1 is lower. If it's greater, it returns 1 indicating version1 is higher. If all components are equal, it returns 0.

// Dry run code:
// Input: version1 = "1.01", version2 = "1.001"
// str1.length=2, str2.length=2
// max(2,2)=2
// num1= 0,1>=2 no so Integer.parseInt(str1[i]) -> 1
// num2= 0,1>=2 no so Integer.parseInt(str2[i]) -> 1
// num1==num2 -> return 0

// Input: version1 = "1.0", version2 = "1.0.0"
// str1.length=2, str2.length=3
// max(2,3)=3
// num1= 0,1,2>=2 yes so num1=0
// num2= 0,1,2>=3 no so Integer.parseInt(str2[i]) -> 0
// num1==num2 -> return 0

// Input: version1 = "0.1", version2 = "1.1"
// str1.length=2, str2.length=2
// max=(2,2)=2
// num1= 0,1>=2 no, Integer.parseInt(str1[i]) -> 0
// num2= 0,1>=2 no, Integer.parseInt(str2[i]) -> 1
// num1<num2 -> return -1