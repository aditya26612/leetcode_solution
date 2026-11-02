// 5 ms | 42.6 MB
class Solution {
    public String reorganizeString(String s) {
        HashMap<Character,Integer> hash = new HashMap<>();

        for(char temp:s.toCharArray()){
            hash.put(temp,hash.getOrDefault(temp,0)+1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(b[1], a[1])
        );

        for (Map.Entry<Character, Integer> entry : hash.entrySet()) {
            char ch = entry.getKey();
            int freq = entry.getValue();

            pq.offer(new int[]{ch, freq});
        }

        // for (char key : hash.keySet()) {
        //     pq.offer(new int[]{key, hash.get(key)});
        // }

        int[] temp1=pq.poll();
        int maxfreq=temp1[1];

        if(maxfreq > ((s.length() +1)/2)){
            return "";
        }

        pq.offer(temp1);

        // StringBuffer st=new StringBuffer();
        
        // while(!pq.isEmpty()){
        
        // temp1=pq.poll();

        // st.append((char) temp1[0]);
        // temp1[1]-=1;;
        

        // if(!pq.isEmpty()){
        // int[] temp2=pq.poll();
        // st.append((char) temp2[0]);
        // temp2[1]-=1;

        // if(temp2[1]!=0){
        //     pq.offer(temp2);
        // }}
        // if(temp1[1]!=0){
        //     pq.offer(temp1);
        // }}
        
        StringBuilder st = new StringBuilder();

        int[] prev = null;

        while (!pq.isEmpty()) {

            int[] current = pq.poll();
            st.append((char) current[0]);
            current[1]--;

            if (prev != null && prev[1] > 0) {
                pq.offer(prev);
            }

            prev = current;
        }


        return st.toString();
    }
}