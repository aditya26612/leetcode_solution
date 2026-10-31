// 3 ms | 44.9 MB
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] result =new int[nums1.length];
        HashMap<Integer,Integer> hash=new HashMap<>();

        for(int num:nums2){
            while( !stack.isEmpty() && num > stack.peek()){
                int pop=stack.pop();
                hash.put(pop,num);
            }
            stack.push(num);
        }

        while(!stack.isEmpty()){
            hash.put(stack.pop(),-1);
        }

        for(int i=0;i<nums1.length;i++){
            result[i]=hash.get(nums1[i]);
        }

        return result;
    }
}