// 23 ms | 80.4 MB
class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack =new ArrayDeque<>();
        int maxArea=0;
        
        

        for(int i=0;i <heights.length;i++){
            
            while(!stack.isEmpty() && heights[i] < heights[stack.peek()]){
                int index=stack.pop();

                int height=heights[index];

                int rightBoundary= i;

                int leftBoundary = stack.isEmpty() ? -1 : stack.peek();

                int area=(rightBoundary-leftBoundary -1) * height ;

                if(area> maxArea) maxArea=area;
            }
            stack.push(i);
        }
        
        while (!stack.isEmpty()) {

            int index = stack.pop();

            int height = heights[index];

            int rightBoundary = heights.length;

            int leftBoundary = stack.isEmpty() ? -1 : stack.peek();

            int width = rightBoundary - leftBoundary - 1;

            int area = width * height;

            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}