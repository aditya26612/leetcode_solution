// 32 ms | 102.5 MB
class MinStack {

    Deque<Integer> stack = new ArrayDeque<>();
    Deque<Integer> stackMin = new ArrayDeque<>();

    int min;
    public MinStack() {
        this.min=min;
    }
    
    public void push(int value) {
        if(stack.isEmpty()) stackMin.push(value);
        else{
            if(stackMin.peek() >= value ) {
                stackMin.push(value);
            } 
        }

        stack.push(value);
    }
    
    public void pop() {
        if(stack.peek().equals(stackMin.peek())){
            
            stackMin.pop();
        }
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return stackMin.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */