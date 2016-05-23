public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //If car starts at A and can not reach B. Any station between A and B can not reach B.
        //If the total number of gas is bigger than the total number of cost. There must be a solution.
            
        //int len = gas.length();
        int sumgas = 0,sumcost =0 ,tank = 0,start = 0;
        for(int i = 0; i< gas.length; i++){
            sumgas += gas[i];
            sumcost += cost[i];
            tank += gas[i] - cost[i];
            if(tank < 0){
                tank = 0;
                start = i+1; // start from the next pos
            }
        }
        if(sumgas < sumcost) return -1;
        return start;
    }
}
