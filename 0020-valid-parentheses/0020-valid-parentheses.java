class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='(' || ch=='{' || ch=='['){
                stk.push(ch);
            }
            else{
                if(stk.empty()){
                    return false;
                }
                if(ch==')' && stk.peek()=='('){
                    stk.pop();
                }
                else if(ch=='}' && stk.peek()=='{'){
                    stk.pop();
                }
                else if(ch==']' && stk.peek()=='['){
                    stk.pop();
                }
                else{
                    return false;
                }
            }
        }
        return stk.isEmpty();
    }
}
// T.C -> O(n)
// S.C -> O(n)

// 1) Loop go through all characters in a string. If you find opening bracket, push it in stack
// 2) If you find closing bracket, we need to mactch the element on the top of stack and closing bracket in a string. If they are matching remove character from stack until we get the empty stack and and we go through all characters in a string
// 3) If stack is empty and no character left in a string to compare with the character in stack, it is valid parenthesis which return true otherwise return false