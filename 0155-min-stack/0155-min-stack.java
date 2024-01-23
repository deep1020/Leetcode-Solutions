class MinStack {
    // Two stacks
    Stack<Integer> st=new Stack<>();
    Stack<Integer> min_vals=new Stack<>(); 
    public MinStack() {
        
    }
    
    public void push(int val) {
        // If val is less than or equals to current minumum which is peek of the stack then push into min_vals stack
        // Now min_vals stack contains minimum value at the top
        // st stack contains all values
        if(min_vals.isEmpty() || val<=min_vals.peek()){
            min_vals.push(val); // [-2,-3]
        }
        st.push(val); // [-2,0,-3]
    }
    
    public void pop() {
        if(st.peek().equals(min_vals.peek())){
            min_vals.pop(); // -3 and -3 equals so remove it now min_vals stack has [-2]
        }
        st.pop(); // remove -3 from [-2,0,-3] now st stack has [-2,0]
    }
    
    public int top() {
        return st.peek(); // [0]
    }
    
    public int getMin() {
        return min_vals.peek(); // [-2]
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */