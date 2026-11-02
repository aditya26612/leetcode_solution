// 31 ms | 47.8 MB
class Solution {
    public int leastInterval(char[] tasks, int n) {

        HashMap<Character,Integer> map=new HashMap<>();

        PriorityQueue<Integer> maxHeap =new PriorityQueue<>(Collections.reverseOrder());

        Queue<int[]>cooldownQueue = new LinkedList<>();

        int time =0;
        for(char t:tasks) {
            map.put(t,map.getOrDefault(t,0)+1);
        }


        for(int freq:map.values()){
            maxHeap.offer(freq);
        }

        while(!maxHeap.isEmpty()||!cooldownQueue.isEmpty()) {

            while(!cooldownQueue.isEmpty()&& cooldownQueue.peek()[1] <= time) {
                        // We don't actually need task identities to calculate the minimum number of intervals. Tasks with equal frequencies are interchangeable for this problem.

        // Therefore, storing only frequencies in the heap is sufficient.
            maxHeap.offer(cooldownQueue.poll()[0]);
            }

            if(!maxHeap.isEmpty()){

                int freq= maxHeap.poll();
                freq--;

                if(freq>0){
                    cooldownQueue.offer(new int[]{freq,time+n+1});
                }
            }

            time++;
        }

        return time;
    }
}