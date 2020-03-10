package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCodeWeeklyTestWeek179Question5354 {
	public static void main(String[] args) {
		int n=11; int headID=4;
		int [] manager = new int[] {5,9,6,10,-1,8,9,1,9,3,4};
		int [] information=new int[] {0,213,0,253,686,170,975,0,261,309,337};
		int res = numOfMinutes(n, headID, manager, information);
		System.out.println(res);
	}
	public static int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
		int total =0;
		Queue<Integer> curManager = new LinkedList<Integer>();
		curManager.add(headID);
		total = helper(total,curManager,manager,informTime);
		return total;
	}

	private static int helper(int total, Queue<Integer> curManager, int[] manager, int[] information) {
		if(curManager.size()==0)
			return total;
		int time =0;
		int curId = -1;
		int size =curManager.size();
		for(int i=0;i<size;i++) {
			int curManagerId = curManager.poll();
			for(int k=0;k<manager.length;k++) {
				if(manager[k]==curManagerId)
					curId = k;
			}
			for(int j=0;j<manager.length;j++) {
				if(manager[j]==curManagerId) {
					curManager.add(j);
					time=Math.max(time, information[curId]);
				}
			}
		}
		total+=time;
		return helper(total,curManager,manager,information);
	}
}
