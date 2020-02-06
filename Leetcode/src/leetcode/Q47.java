package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q47 {
	public static void main(String[] args) {
		int nums[]=new int [] {1,1,2};
		Q47 q47 = new Q47();
		List<List<Integer>> res=q47.permuteUnique(nums);
	}
	public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();//store res
        List<Integer> index;//used to indicated weather the current value has been
        					//already used or not, if already used, continue next cycle
        Arrays.sort(nums);
        List<Integer> list;
        int pos;
        for(int i=0;i<nums.length;i++){
            list = new ArrayList<Integer>();
            index=new ArrayList<Integer>();
            pos=1;
            list.add(nums[i]);
            index.add(i);
            helpler(nums,index,res,list,pos);
        }
        return res;
    }

    private void helpler(int[] nums, List<Integer> index, List<List<Integer>> res, List<Integer> list, int pos){
        if(index.size()==nums.length){
            for(List<Integer> l:res){
                if(l.equals(list))
                    return;
            }
            res.add(new ArrayList<Integer>(list));
            return;
        }
        outer:for(int i=0;i<nums.length;i++){
        	for(int n:index) {//to check whether the valued has been used
        		if(n==i)
        			continue outer;
        	}
        	list.add(nums[i]);
            index.add(i);
            helpler(nums,index,res,list,++pos);
            list.remove(list.size()-1);
            index.remove(index.size()-1);
        }
    }
}
