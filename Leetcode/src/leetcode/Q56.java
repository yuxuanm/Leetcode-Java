package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Q56 {
	public static void main(String[] args) {
		int [][] intervals=new int[][] {new int[] {6,4},new int[] {0,4},new int[] {4,5}};
		Q56 q56 = new Q56();
		int [][] res = q56.merge(intervals);
	}
	public int[][] merge(int[][] intervals) {
		//sort the intervals, ASC
		Arrays.sort(intervals, new Comparator<int []>() {

			@Override
			public int compare(int[] o1, int [] o2) {
				
				return o1[0]-o2[0];
			}
		});

		
		for(int i=0;i<intervals.length;i++){
             if(i==intervals.length-1){
                 break;
             }
             if(intervals[i+1][0]<=intervals[i][1]&&intervals[i+1][0]>=intervals[i][0]){
                 int min = Math.min(Math.min(intervals[i][1],intervals[i][0]),Math.min(intervals[i+1][1],intervals[i+1][0]));
                 int max = Math.max(Math.max(intervals[i][1],intervals[i][0]),Math.max(intervals[i+1][1],intervals[i+1][0]));
                 intervals[i]=new int[]{-1,-1};
                 intervals[i+1]=new int[]{min,max};
             }
         }      
        intervals=removeNegativeOnes(intervals);
        return intervals;
    }
    
    public int[][] removeNegativeOnes(int[][] intervals){
        int cnt=0;
        for(int i=0;i<intervals.length;i++){
            if(intervals[i][0]!=-1||intervals[i][1]!=-1)
                cnt++;
        }
        int index=0;
        int[][] res = new int[cnt][2];
        for(int i=0;i<intervals.length;i++){
            if(intervals[i][0]!=-1||intervals[i][1]!=-1){
                res[index]=intervals[i];
                index++;
            }
        }
        return res;
    }
    
}
