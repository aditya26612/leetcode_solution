// 3 ms | 42.9 MB
class Solution {

    

    public boolean isValid(String s) {
        
    if(s.length()==1){
        return false;
    }

    Deque<Character> stack = new ArrayDeque<>();

    for(char temp:s.toCharArray()){
        if(temp== '(' || temp=='[' || temp=='{'){
            stack.push(temp);
        }

        else {
            if(stack.isEmpty()) stack.push(temp);

            else if(stack.peek().equals('(') && temp==')' 
            || stack.peek().equals('[') && temp==']' 
            || stack.peek().equals('{') && temp=='}'
            ){
                stack.pop();
            }

            else stack.push(temp);
        }
    }

        return stack.isEmpty();
    }
}