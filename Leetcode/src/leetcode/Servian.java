package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Servian {
	public static int minNum(int threshold, List<Integer> points) {
		  // Write your code here
	       int size = points.size()-2;
	       if((points.get(points.size()-1)-points.get(2))<threshold)
	            return size;
	        int end = 0;
	        for(int i=3;i<points.size();i++){
	            if((points.get(i)-points.get(2))>=threshold)
	                end =i;
	        }
	        return 2+(end-2-1)/2;
	        
	    }
	
	public static void main(String[] args) {
//		List<Integer> list = new ArrayList<Integer>();
//		list.add(4);
//		list.add(4);
//		list.add(1);
//		list.add(3);
//		list.add(4);
//		list.add(7);
//		
//		System.out.println(minNum(4, list));
		
		List<List<Integer>> list = new ArrayList<List<Integer>>();
	}
}
