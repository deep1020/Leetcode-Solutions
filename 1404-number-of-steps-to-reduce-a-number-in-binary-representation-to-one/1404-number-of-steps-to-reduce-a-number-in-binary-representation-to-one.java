class Solution {
    public int numSteps(String s) {
        int steps=0;
        while(s.length()>1){
            if(s.charAt(s.length()-1)=='0'){
                s=s.substring(0,s.length()-1);
            } 
            else{
                s=addOne(s);
            }
            steps++;
        }
        return steps;
    }
    private String addOne(String s) {
        StringBuilder result=new StringBuilder();
        int carry=1;
        for(int i=s.length()-1;i>=0;i--){
            int sum=(s.charAt(i)-'0')+carry;
            result.append(sum%2);
            carry=sum/2;
        }
        if(carry==1){
            result.append(carry);
        }
        return result.reverse().toString();
    }
}
// T.C -> O(n) Each step involves either removing the last character O(1) or adding 1 to the string O(n)
// total number of steps is proportional to the length of binary string and its logarithmic reduction in size.
// S.C -> O(n) storage required for the binary string during manipulation.

// numSteps Function:
// 1) keeps reducing the binary string until its length is 1.
// 2) If the last character is '0', the binary number is even, and we remove the last character to divide by 2.
// Ex: s="1110" = 14 remove last character '111' = 7 (half of s)
// 3) If the last character is '1', the binary number is odd, and we add 1 to it using the addOne function.

// addOne Function:
// 1) It adds 1 to a binary string. It processes the string from the least significant bit to the most significant bit, performing the addition with carry.
// 2) If there's a carry left after processing all bits, it appends '1' at the beginning.
// s="1101"
// Last character is '1' (odd), so we add 1 to it.
// Call addOne("1101"):
// Start with carry = 1.
// Add carry to the last digit (1+1=2, write 0, carry=1).
// Add carry to the next digit (0+1=1, write 1, carry=0).
// Add carry to the next digit (1+0=1, write 1, carry=0).
// Add carry to the next digit (1+0=1, write 1, carry=0).
// return a string in reverse order of write i.e '1110'
// If we get a carry 1 at the end of loop, add 1 at the beginning of string i.e '1000'
// Ex: s='111' addoOne -> '1000'



class Solution2 { // Some testcases failed e.g "1111011110000011100000110001011011110010111001010111110001"
    public int numSteps(String s) {
        int decimal=binaryToDecimal(s);
        int steps=0;
        while(decimal>1) {
            if(decimal%2==0){
                decimal/=2;
            } 
            else{
                decimal+=1;
            }
            steps++;
        }
        return steps;
    }
    public static int binaryToDecimal(String binaryString) {
        int decimal=0;
        int base=1;
        for(int i=binaryString.length()-1;i>=0;i--){
            if(binaryString.charAt(i)=='1'){
                decimal+=base;
            }
            base=base*2;
        }
        return decimal;
    }
}