// 2 ms | 119.2 MB
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalTank=0;
        int currentTank=0;

        int[] netGas=new int[gas.length];

        for(int i=0;i<gas.length;i++){
            netGas[i]=gas[i]-cost[i];
            totalTank+=netGas[i];
        }

        if(totalTank<0){
            return -1;
        }

        int start=0;

        for(int i=0;i<gas.length;i++){
            currentTank+=netGas[i];
            if(currentTank <0){
                start=i+1;
                currentTank=0;
            }
        }

        return start;
    }
}