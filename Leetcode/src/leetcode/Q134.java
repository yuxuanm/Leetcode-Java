package leetcode;

public class Q134 {
	public static void main(String[] args) {
		
		int [] gas = new int [] {3,1,1};
		int [] cost = new int [] {1,2,2};
		int res = canCompleteCircuit(gas, cost);
		System.out.println(res);
	}
	
	
	public static int canCompleteCircuit(int[] gas, int[] cost) {
        int cur_tank = 0;
        int total_tank = 0;
        int start = 0;
        for(int i =0;i<gas.length;i++){
            total_tank = total_tank+gas[i]-cost[i];
            cur_tank = cur_tank+ gas[i]-cost[i];
            if(cur_tank<0){
                start=i+1;
                cur_tank = 0;
            }
        }
        return total_tank>=0?start==gas.length?0:start:-1;
    }
	/**Method 1: O(N^2) iterate the arrays two times;
	 * */
//	public static int canCompleteCircuit(int[] gas, int[] cost) {
//		for (int i = 0; i < gas.length; i++) {
//			if (gas[i] >= cost[i]) {
//				int res = helper(gas, cost, i);
//				if (res != -1)
//					return res;
//			}
//		}
//		return -1;
//	}
//
//	public static int helper(int[] gas, int[] cost, int start) {
//		int tank = 0;
//		int position = start;
//		boolean flag = true; // to prevent our starting point start= 0, which will directly return 0;
//		while (true) {
//			if (position == gas.length)
//				position = 0;
//			if (position == start && tank >= 0 && !flag)
//				return position;
//			flag = false;
//			tank = tank + gas[position] - cost[position++];
//			if (tank < 0)
//				return -1;
//		}
//	}
}
