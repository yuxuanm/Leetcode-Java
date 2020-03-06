package leetcode;

import java.util.ArrayList;
import java.util.List;

public class InterviewQ57 {
	public static void main(String[] args) {
		int [][] res = findContinuousSequence(9);
	}
	
	/**dont know why the question ask Java to return an int[][] array 
	 * */
	public static int[][] findContinuousSequence(int target) {
        int sum = 0;
        List<List<Integer>> resList = new ArrayList<List<Integer>>();
        List<Integer> list;
        for(int i=1;i<=target/2;i++){
            int start = i;
            list = new ArrayList<Integer>();
            sum=0;
            while(sum<target){
                list.add(start);
                sum+=start++;
                if(sum==target)
                    resList.add(list);
            }
        }
        
        if(resList.size()==0)
        	return null;
        int [][] res = new int[resList.size()][];
        for(int j=0;j<res.length;j++){
            int [] arr = new int[resList.get(j).size()];
            for(int i=0;i<arr.length;i++){
                arr[i]=resList.get(j).get(i);
            }
            res[j]=arr;
        }
        return res;
    }
}
