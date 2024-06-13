class Solution {
    public String intToRoman(int num) {
        int value[]={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String symbol[]={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder romanNumeral=new StringBuilder();
        for(int i=0;i<value.length;i++){
            while(num>=value[i]){
                num-=value[i];
                System.out.println(num);
                romanNumeral.append(symbol[i]);
            }
        }
        return romanNumeral.toString();
    }
}
// T.C -> O(n) iterate through each values in value array 
// S.C -> O(1) space remains constant as input size is fixed
// Initialize two arrays, value and symbol, to hold integer values and corresponding Roman numeral symbols.
// Loop through each value in the value array while num is greater than 0, stopping when all symbols have been processed.
// For each value, check if it fits into num, appending the corresponding Roman numeral symbol to a string.
// Subtract the value of the current symbol from num after appending the symbol to the StringBuilder.
// Convert StringBuilder to string and return it 