// 4 ms | 42.7 MB
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
            if(stack.isEmpty()) return false;

            else if(stack.peek().equals('(') && temp==')' 
            || stack.peek().equals('[') && temp==']' 
            || stack.peek().equals('{') && temp=='}'
            ){
                stack.pop();
            }

            else return false;
        }
    }

        return stack.isEmpty();
    }
}