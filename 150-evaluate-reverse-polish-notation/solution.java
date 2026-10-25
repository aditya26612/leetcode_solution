// 7 ms | 44.8 MB
class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack=new ArrayDeque<>();
        int n1,n2;
        for(int i=0;i<tokens.length;i++){
            if(tokens[i].equals("+")){
                n1=stack.pop();
                n2=stack.pop();
                stack.push(n2+n1);

            }    
            else if( tokens[i].equals("*")){
                n1=stack.pop();
                n2=stack.pop();
                stack.push(n2*n1);                
            }    
            else if(tokens[i].equals("-")){
                n1=stack.pop();
                n2=stack.pop();
                stack.push(n2-n1);   
            }

            else if(tokens[i].equals("/")) {
                n1=stack.pop();
                n2=stack.pop();
                stack.push(n2/n1);
            }
            else{
                stack.push(Integer.parseInt(tokens[i]));
            }

        }

        return stack.peek();
    }
}