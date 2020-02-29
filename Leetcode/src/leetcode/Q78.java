package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q78 {
	List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list;
        for(int i =0;i<=nums.length;i++){
            list = new ArrayList<Integer>();
            sub(list,nums,i,0);
        }
        
        return res;
    }
    
    private void sub(List<Integer> list, int[] nums, int i, int index){
        if(list.size()==i)
            res.add(new ArrayList<Integer>(list));
        for(int j=0;j<nums.length;j++){
            if(list.contains(nums[j])||j<index)
                continue;
            list.add(nums[j]);
            sub(list,nums,i,j);
            list.remove(list.size()-1);
        }
    }
}
