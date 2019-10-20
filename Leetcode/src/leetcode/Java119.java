package leetcode;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

public class Java119 {

	

//	public List<Integer> generate(int rowIndex) {
//		List<List<Integer>> sumList = new ArrayList<List<Integer>>();
//
//		for (int i = 0; i <=rowIndex; i++) {
//			if (i == 0) {
//				List<Integer> list = new ArrayList<Integer>();
//				list.add(1);
//				sumList.add(list);
//				if (rowIndex==0)
//					return sumList.get(rowIndex);
//				continue;
//			}
//			if (i == 1) {
//				List<Integer> list2 = new ArrayList<Integer>();
//				list2.add(1);
//				list2.add(1);
//				sumList.add(list2);
//				if (rowIndex==1)
//					return sumList.get(rowIndex);
//				continue;
//			}
//
//			List<Integer> pre =  sumList.get(i - 1);
//			List<Integer> cur = new ArrayList<Integer>();
//			for (int j = 0; j <= i; j++) {
//				if (j == 0)
//					cur.add(1);
//				if (j != 0 && j != i) {
//					cur.add(pre.get(j - 1) + pre.get(j));
//				}
//				if (j == i) {
//					cur.add(1);
//				}
//			}
//			sumList.add(cur);
//		}
//		return sumList.get(rowIndex);
//	}
	public static List<Integer> generate(int rowIndex){
		List<Integer> list = new ArrayList<Integer>(rowIndex+1);
		list.add(1);
		for(int i =0;i<rowIndex;i++) {
			long pre = list.get(i);
			long cur = pre*(rowIndex-i)/(i+1);
			list.add((int)cur);
		}
		return list;
	}
	public static void main(String[] args) {
		System.out.println(generate(30).toString());
	}
	
}
